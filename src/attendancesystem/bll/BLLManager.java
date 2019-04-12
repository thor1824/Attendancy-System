/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;

import attendancesystem.bll.facade.IBuisness;
import attendancesystem.bll.essentials.PieChartGenerater;
import attendancesystem.bll.essentials.PasswordEncryptor;
import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import attendancesystem.be.Absence;
import attendancesystem.bll.essentials.CalenderOrganiser;
import attendancesystem.bll.essentials.IScanner;
import attendancesystem.bll.essentials.scanner.NFCScanner;
import attendancesystem.dal.db.StudentDbDao;
import attendancesystem.dal.db.AbsenceDbDao;
import attendancesystem.dal.db.LoginDbDao;
import attendancesystem.dal.db.TeacherDbDao;
import java.util.List;
import javafx.scene.chart.PieChart;
import attendancesystem.dal.facade.IAbsenceDAO;
import attendancesystem.dal.facade.ILoginDAO;
import attendancesystem.dal.facade.IStudentDAO;
import attendancesystem.dal.facade.ITeacherDAO;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Nijas Hansen
 */
public class BLLManager implements IBuisness
{

    private ITeacherDAO teachDao;
    private IStudentDAO studentDao;
    private IAbsenceDAO absenceDao;
    private ILoginDAO loginDao;
    private IScanner nfc;
    private List<Student> students;
    private CalenderOrganiser calOrg;
    private List<Integer> absend;
    private List<Integer> presend;

    public BLLManager()
    {
        try
        {
            this.loginDao = new LoginDbDao();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            this.teachDao = new TeacherDbDao();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            this.absenceDao = new AbsenceDbDao();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            this.studentDao = new StudentDbDao();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            this.nfc = new NFCScanner();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            this.calOrg = new CalenderOrganiser();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            this.presend = new ArrayList<>();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public boolean scan()
    {

        //        String nfcCode = scanscan
        Calendar cal = Calendar.getInstance();

        String absendDay = calOrg.checkDate(cal);

        if (absendDay != null)
        {
            System.out.println("ABSENCE!!!");
            System.out.println();
            //markAbsend(absendDay);
        }
        System.out.println(nfc);
        int studentID = Integer.parseInt(nfc.scan());
        if (!isAllreadyPresend(studentID))
        {

            presend.add(studentID);
            System.out.println("You have bin marked as presend");
            return true;
            //return sDAO.addDaysOfClass(studentID);
        }

        return false;

    }

    private boolean isAllreadyPresend(int id)
    {
        for (Integer student : presend)
        {
            if (id == student)
            {
                System.out.println("allready presend");
                return true;
            }
        }
        return false;
    }

    private void markAbsend(String day) throws Exception
    {
        absend = new ArrayList<>();
        for (Student student : students)
        {
            boolean isAbsend = true;
            for (Integer i : presend)
            {
                if (i.intValue() == student.getStuID())
                {
                    isAbsend = false;
                }
            }
            if (isAbsend)
            {
                absend.add(student.getStuID());
            }

        }
        absenceDao.createAbsenceBatch(absend, day);
    }

    @Override
    public List<Student> getAllStudents() throws Exception
    {
        if (students == null)
        {
            students = studentDao.getAllStudents();
        }
        return students;
    }

    @Override
    public boolean createAbsence(Absence absence, Student student) throws Exception
    {
        return absenceDao.createAbsence(absence, student);
    }

    @Override
    public List<Absence> getUndocumentetAbsence(Student user) throws Exception
    {
        return absenceDao.getUndocumentetAbsence(user);
    }

    @Override
    public List<Absence> getDocumentetAbsence(Student user) throws Exception
    {
        return absenceDao.getDocumentetAbsence(user);
    }

    @Override
    public boolean updateAbsence(Absence absence) throws Exception
    {
        return absenceDao.updateAbsence(absence);
    }

    @Override
    public List<Absence> getAllAbsence(Student student) throws Exception
    {
        return absenceDao.getAllAbsence(student);
    }

    @Override
    public List<Absence> getAllRequestAbence(Teacher teacher) throws Exception
    {
        return absenceDao.getAllRequestAbence(teacher);
    }

    @Override
    public boolean makeAbsenceRequest(Absence absence) throws Exception
    {
        return absenceDao.makeAbsenceRequest(absence);
    }

    @Override
    public boolean approveRequest(Absence absence) throws Exception
    {
        return absenceDao.approveRequest(absence);
    }

    @Override
    public boolean declineAbsenceRequest(Absence absence) throws Exception
    {
        return absenceDao.declineAbsenceRequest(absence);
    }

    @Override
    public Teacher handleLoginRequestTeacher(String username, String password) throws Exception
    {

        String hashedPassword = PasswordEncryptor.encryptPassword(password);

        return loginDao.handleLoginRequestTeacher(username, hashedPassword);
    }

    @Override
    public Student handleLoginRequestStudent(String username, String password) throws Exception
    {

        String hashedPassword = PasswordEncryptor.encryptPassword(password);

        return loginDao.handleLoginRequestStudent(username, hashedPassword);
    }

    @Override
    public List<String> getSchoolClasses(Teacher teacher) throws Exception
    {
        return teachDao.getSchoolClasses(teacher);
    }

    @Override
    public PieChart getPieChart(Student student) throws Exception
    {
        int daysPresend = student.getDaysPrecend();
        int daysUndocAbsence = student.getUndocAbsence();
        int daysDocAbsence = student.getDocAbsence();

        return PieChartGenerater.buildPieChard(student, daysPresend, daysUndocAbsence, daysDocAbsence);
    }

}

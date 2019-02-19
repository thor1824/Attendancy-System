/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.be;

/**
 *
 * @author Bruger
 */
public class ModulFravær
{
    private boolean canceled;
    private String teacher;
    private String classStart;
    private String classEnded;
    private String module;
    
    
    public ModulFravær(boolean canceled, String teacher,String module, String classStart, String classEnded)
    {
        this.canceled = canceled;
        this.teacher = teacher;
        this.module = module;
        this.classStart = classStart;
        this.classEnded = classEnded;
    }
    
    
    /**
     * Get the value of module
     *
     * @return the value of module
     */
    public String getModule()
    {
        return module;
    }

    /**
     * Set the value of module
     *
     * @param module new value of module
     */
    public void setModule(String module)
    {
        this.module = module;
    }

    
    /**
     * Get the value of classEnded
     *
     * @return the value of classEnded
     */
    public String getClassEnded()
    {
        return classEnded;
    }

    /**
     * Set the value of classEnded
     *
     * @param classEnded new value of classEnded
     */
    public void setClassEnded(String classEnded)
    {
        this.classEnded = classEnded;
    }
    

    /**
     * Get the value of classStart
     *
     * @return the value of classStart
     */
    public String getClassStart()
    {
        return classStart;
    }

    /**
     * Set the value of classStart
     *
     * @param classStart new value of classStart
     */
    public void setClassStart(String classStart)
    {
        this.classStart = classStart;
    }

    /**
     * Get the value of teacher
     *
     * @return the value of teacher
     */
    public String getTeacher()
    {
        return teacher;
    }

    /**
     * Set the value of teacher
     *
     * @param teacher new value of teacher
     */
    public void setTeacher(String teacher)
    {
        this.teacher = teacher;
    }

    /**
     * Get the value of canceledHour
     *
     * @return the value of canceledHour
     */
    public boolean isCanceledHour()
    {
        return canceled;
    }

    /**
     * Set the value of canceledHour
     *
     * @param canceled new value of canceledHour
     */
    public void setCanceledHour(boolean canceled)
    {
        this.canceled = canceled;
    }
    
}


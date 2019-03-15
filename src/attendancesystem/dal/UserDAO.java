/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.be.User;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public interface UserDAO
{

    User handleLoginRequest(String username, String password);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaiko;

/**
 *
 * @author takizawaryoutarou
 */
public class LoginLogic {

    public boolean execute(User user) {
        if (user.getPass().equals("5678")) {
            return true;
        } else {
            return false;
        }

    }
}

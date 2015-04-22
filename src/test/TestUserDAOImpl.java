package test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.bean.User;
import com.dao.UserDAO;

public class TestUserDAOImpl extends BaseSpringContextCommon {	 
      
    @Autowired  
    @Qualifier("userDAO")  
    private UserDAO userDAO;  
      
    @Test   
    public final void testSave() {  
    	User user = new User();
    	user.setUsername("tousername");
        user.setEmail("myemail");      
        user.setPassword("myjassword"); 
        user.setTime(new Date());
        userDAO.saveUser(user);     
    }  
}

package test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.util.ErrorType;

import com.service.UserService;
import com.service.PinService;

import com.bean.User;
import com.dao.PinDAO;
import com.dao.UserDAO;


public class PinServiceImplTest extends BaseSpringContextCommon{
	
	@Autowired  
    @Qualifier("pinDAO")  
    private PinDAO pinDAO;	
	@Autowired
	@Qualifier("userDAO")  
    private UserDAO userDAO;
	
	@Autowired  
    @Qualifier("userService")  
    private UserService userService;
	
	@Autowired  
    @Qualifier("pinService")  
    private PinService pinService;
	
	@Test
	public void testAddBoard(){
		String username = "Alice";
		String bname = "happy";
		ErrorType errortype = pinService.addBoard(username, bname);
		assertEquals(ErrorType.NO_ERROR, errortype);
	}
	
	

}
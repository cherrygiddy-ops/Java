package Collections;
import Generics.User;

import java.util.HashMap;
import java.util.Map;

public class Maps {
    private final Map<String , User> users = new HashMap<>();

    public void  addUsers(){
        users.put("e1",new User());
        users.put("e2",new User());
    }

    public  void  getCustomer(String gmail){
        System.out.println(users.get(gmail));
    }
}

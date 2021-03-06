package springbootpart3;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public  class UserServiceImpl implements UserService {




    FakeRepo fakeRepo=new FakeRepo();


    public String addUser(long id, String name, String surname) {

        return fakeRepo.insertUser(id,name,surname);
    }


    @Override
    public String removeUser(long Id) {


        return fakeRepo.deleteUser(Id);
    }


    @Override
    @Cacheable("User")
    public String getUser(long Id) {

        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


        return fakeRepo.findUserById(Id);
    }

//    public String gitApi(){
//
//
//        RestTemplate restTemplate=new RestTemplate();
//
//        String url="https://api.github.com";
//
//        ResponseEntity<String> response = restTemplate.getForEntity(url+"/users/Ngwako-dev/repos", String.class);
//        System.out.println("response "+response.toString());
//
//
//        return response.toString();
//
//    }


}

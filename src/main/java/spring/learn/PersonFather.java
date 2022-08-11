package spring.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: weijli
 * date: 2021/12/1 11:26
 * description:
 */

@Controller
public class PersonFather {
  @Autowired
   Person person;
  @GetMapping("/test")
  @ResponseBody
  public String test(){
    HashMap map;
    int [] nums={1};
    Arrays.stream(nums).boxed().collect(Collectors.toList());


    System.out.println(person.getAddress());
    return "123";
  }
public List<List> tsum(int[] nums){
  List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
  list.sort((o1, o2) -> o1-o2);
  
  int target=0;
  int l=0;int r=list.size()-1;
  int mid=1;
  ArrayList<List> res =new ArrayList<>();
  while(l<mid&&mid<r){
    int tempres= list.get(l)+list.get(r)+list.get(mid);
    if(tempres==0){
      List<Integer> subList= new ArrayList<>();
      subList.add(list.get(l));
      subList.add(list.get(r));
      subList.add(list.get(mid));
      res.add(subList);
    }else if(tempres>0){
      r--;
    }else {
      l++;
    }
    
    
    
  }
  return res;
  
}

//要求：期望平均时间复杂度为 O(nlogn)，期望额外空间复杂度为 O(logn)。
  
}

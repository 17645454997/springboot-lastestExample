package com.xingjiahe.www;


import com.xingjiahe.www.context.AccessContext;
import com.xingjiahe.www.filter.AbstractAccessFilter;
import com.xingjiahe.www.filter.ExerciseFilter;

import java.util.ArrayList;
import java.util.List;

public class TestStream {


    public static void main(String[] args) {
        List<AbstractAccessFilter<AccessContext>> accessFilters = new ArrayList<>();
        ExerciseFilter exerciseFilter =  new ExerciseFilter();
        AccessContext accessContext = new AccessContext();
        accessContext.setUserNewId(110L);
        accessContext.setMethod("journeyList");
       // accessFilters.add(exerciseFilter);
        accessFilters.forEach(accessFilter -> accessFilter.filter(accessContext));

//        User user1 = new User(15,Arrays.asList("fg", "asd", "ada") );
//        User user2 = new User(16, Arrays.asList("fg", "asd", "ada"));
//        User user3 = new User(17, Arrays.asList("df", "ererw", "ada"));
//        User user4 = new User(18, Arrays.asList("dgdg", "asd", "ada"));
//        User user5 = new User(19, Arrays.asList("dgdg", "asd", "ada"));
//        List<User> userGroup = new ArrayList<>();
//        userGroup.add(user1);
//        userGroup.add(user2);
//        userGroup.add(user3);
//        userGroup.add(user4);
//        userGroup.add(user5);
//        List<Object>result = new ArrayList<>();
//        userGroup.forEach(e->result.add(Stream.of(e.friendName.stream()).flatMap(StringStream->StringStream).collect(Collectors.toList())));
//        Stream<String> stringStream1 = Arrays.asList("fgd","dfg","dghd").stream();
//        Stream<String> stringStream2 = Arrays.asList("dfhwe","ert","hrere").stream();
//        List<String> collectResult = Stream.of(stringStream1, stringStream2)
//                .flatMap(StringStream -> StringStream).collect(Collectors.toList());
//        collectResult.forEach(e->System.out.println(e));


    }

}

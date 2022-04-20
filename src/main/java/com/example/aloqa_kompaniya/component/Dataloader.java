//package com.example.aloqa_kompaniya.component;
//
//import com.example.aloqa_kompaniya.entity.Employee;
//import com.example.aloqa_kompaniya.entity.Role;
//import com.example.aloqa_kompaniya.entity.enums.PermissionEnum;
//import com.example.aloqa_kompaniya.entity.enums.RoleEnum;
//import com.example.aloqa_kompaniya.repository.EmployeeRepository;
//import com.example.aloqa_kompaniya.repository.RoleRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Component
//@RequiredArgsConstructor
//public class Dataloader implements CommandLineRunner {
//    final RoleRepository roleRepository;
//    final EmployeeRepository employeeRepository;
//    final PasswordEncoder passwordEncoder;
//    @Value("${spring.sql.init.mode}")
//    private String mode;
//    @Value("${spring.jpa.hibernate.ddl-auto}")
//    private String ddl;
//
//    @Override
//    public void run(String... args) throws Exception {
//        if (ddl.equals("create") && mode.equals("always")) {
//            Role director =roleRepository.save(new Role(1, RoleEnum.DIRECTOR, Arrays.stream(PermissionEnum.values()).collect(Collectors.toSet())));
//            Role manager=roleRepository.save(new Role(2,RoleEnum.MANAGER,new HashSet<>(Arrays.asList(
//                    PermissionEnum.ADD_EMPLOYEE))));
//            Role user=roleRepository.save(new Role(3,RoleEnum.USER,new HashSet<>(Arrays.asList(
//                    PermissionEnum.READ_MOBILEOPERATOR,PermissionEnum.READ_COMPANY,PermissionEnum.READ_TARIFF,PermissionEnum.READ_SIMCARD))));
//
//
//            Set<Role> roles = new HashSet<>();
//            roles.add(director);
//            roles.add(manager);
//            roles.add(user);
//
//            Set<Role> rol=new HashSet<>();
//            rol.add(manager);
//            rol.add(user);
//
//            Set<Role> rollll=new HashSet<>();
//            rollll.add(user);
//
//            Employee employee=new Employee("Bexruz Izzatullayev",roles,"Bekhruz","0000",true);
//            employeeRepository.save(employee);
//            Employee employee1=new Employee("Jamshid",rol,"Jamik","1111",true);
//            employeeRepository.save(employee1);
//            Employee employee2=new Employee("Sardor",rollll,"Sarik","2222",true);
//            employeeRepository.save(employee2);
//        }
//    }
//}

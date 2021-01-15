package com.threegorges.demo.service;




//@Service("EmployeeServiceImpl")
//public class EmployeeServiceImpl implements EmployeeService{
//
//    @Autowired private EmployeeRepository employeeRepository;
//
//    @Autowired private EmployeeCache employeeCache;
//
//    @Override
//    public Employee findByUsernameAndPassword(String name, String password) {
//
//        Employee employee=employeeRepository.findByUsernameAndPassword(name,password);
//        if(employee != null){
//            return employee;
//        }
//        return null;
//    }
//
//    @Override
//    public Employee save(Employee employee) {
//        Employee employee1 = employeeRepository.save(employee);
//        employeeCache.addEmployee(employee1);
//        return employee1;
//    }
//
//
//}

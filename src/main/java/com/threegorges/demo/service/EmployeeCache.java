package com.threegorges.demo.service;



//@Component
//public class EmployeeCache implements InitializingBean {
//
//    private final Map<String, Employee> employeeMap = new ConcurrentHashMap<>(200);
//
//    private final Map<String, Employee> employeeKeyUserMap = new ConcurrentHashMap<>(200);
//
//    @Autowired private EmployeeRepository employeeRepository;
//
//    /**
//     * 初始化用户list的时候执行，可以针对用户list进行配置。employeeMap即缓存，employeeKeyUserMap
//     * @throws Exception
//     */
//    @Override
//    public void afterPropertiesSet() throws Exception {
//      List<Employee> employeeList =  employeeRepository.findAll();
//      employeeList.forEach(e -> {
//          employeeMap.put(e.getName()+"//"+ e.getPassword(),e);
//          employeeKeyUserMap.put(e.getName(),e);
//      });
//    }
//
//    /**
//     * 判断能否登录，用户名和密码组合为key
//     * @param userName 用户名
//     * @param password 密码
//     * @return true为可以
//     */
//    public boolean isLogin(String userName,String password){
//        String key = userName + "//" + password;
//        return employeeMap.containsKey(key);
//    }
//
//    public Employee getEmployeeByName(String userName){
//        return employeeKeyUserMap.get(userName);
//    }
//
//    /**
//     * 添加用户
//     * @param employee
//     */
//    public void addEmployee(Employee employee){
//        employeeKeyUserMap.put(employee.getName(),employee);
//        employeeMap.put(employee.getName()+"//"+employee.getPassword(),employee);
//
//    }
//}

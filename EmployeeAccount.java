import java.util.Scanner;

public class EmployeeAccount extends Account {
    private Employee employee;
    private final AbsenceService absenceService = new AbsenceService();
    private final ResignationService resignationService = new ResignationService();
    private final AttendanceService attendanceService = new AttendanceService();

    public EmployeeAccount(String username, String password, AccountStatus status) {
        super(username, password, status);
    }

    public EmployeeAccount(String username, String password, AccountStatus status, Employee employee) {
        super(username, password, status);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void submitAbsence(Scanner sc) {
        absenceService.submitAbsence(this.employee, sc);
    }

    public void submitResignation(Scanner sc) {
        resignationService.submitResignation(this.employee, sc);
    }

    public void checkIn(Scanner sc) {
        attendanceService.checkIn(this.employee, sc);
    }

    public void checkOut(Scanner sc) {
        attendanceService.checkOut(this.employee, sc);
    }

    public void viewAttendance(Scanner sc) {
        attendanceService.viewAttendance(this.employee, sc);
    }
}


import java.time.LocalDate;
import java.util.Scanner;

public class ResignationService {
    public void submitResignation(Employee employee, Scanner sc) {
        ConsoleUI console = new ConsoleUI();
        String title = "Gửi đơn thôi việc";

        if (employee == null) {
            console.printResult(title, "Tài khoản chưa được liên kết với nhân viên nào.", sc);
            return;
        }

        String reason = console.printUI(title, "", "", "Lý do thôi việc", sc);
        LocalDate date = LocalDate.now();

        Resignation[] resignations = employee.getResignations();
        if (resignations == null) {
            console.printResult(title, "Danh sách đơn thôi việc chưa được khởi tạo.", sc);
            return;
        }

        for (int i = 0; i < resignations.length; i++) {
            if (resignations[i] == null) {
                resignations[i] = new Resignation(reason, date, Resignation.ResignationStatus.PENDING);
                console.printResult(title, "Gửi đơn thôi việc thành công ngày " + date + "! Trạng thái: PENDING", sc);
                return;
            }
        }
        console.printResult(title, "Danh sách đơn thôi việc đã đầy, không thể thêm mới.", sc);
    }
}
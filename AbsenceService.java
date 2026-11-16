import java.time.LocalDate;
import java.util.Scanner;

public class AbsenceService {
    public void submitAbsence(Employee employee, Scanner sc) {
        ConsoleUI console = new ConsoleUI();
        String title = "Gửi đơn xin nghỉ phép";
        String subtitle = "";
        String content = "";

        if (employee == null) {
            console.printResult(title, "Tài khoản chưa được liên kết với nhân viên nào.", sc);
            return;
        }

        String reason = console.printUI(title, subtitle, content, "Lý do nghỉ", sc);
        content += "Lý do: " + reason + "\n";

        LocalDate fromDate = LocalDate.parse(console.printUI(title, subtitle, content, "Từ ngày (YYYY-MM-DD)", sc));
        content += "Từ ngày: " + fromDate + "\n";

        LocalDate toDate = LocalDate.parse(console.printUI(title, subtitle, content, "Đến ngày (YYYY-MM-DD)", sc));

        Absence[] absences = employee.getAbsences();
        if (absences == null) {
            console.printResult(title, "Danh sách đơn nghỉ phép chưa được khởi tạo.", sc);
            return;
        }

        for (int i = 0; i < absences.length; i++) {
            if (absences[i] == null) {
                absences[i] = new Absence(reason, fromDate, toDate, Absence.AbsenceStatus.PENDING);
                console.printResult(title, "Gửi đơn xin nghỉ phép thành công! Trạng thái: PENDING", sc);
                return;
            }
        }
        console.printResult(title, "Danh sách đơn nghỉ phép đã đầy, không thể thêm mới.", sc);
    }
}
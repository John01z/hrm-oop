import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AttendanceService {
    public void checkIn(Employee employee, Scanner sc) {
        ConsoleUI console = new ConsoleUI();
        String title = "Chấm công vào (Check-in)";

        if (employee == null) {
            console.printResult(title, "Tài khoản chưa được liên kết với nhân viên nào.", sc);
            return;
        }

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        Attendance[] attendances = employee.getAttendances();

        if (attendances == null) {
            console.printResult(title, "Danh sách chấm công chưa được khởi tạo.", sc);
            return;
        }

        for (int i = 0; i < attendances.length; i++) {
            if (attendances[i] != null && attendances[i].getDate() != null && attendances[i].getDate().equals(today)) {
                if (attendances[i].getClockIn() != null) {
                    console.printResult(title, "Bạn đã check-in vào lúc " + attendances[i].getClockIn() + " hôm nay rồi.", sc);
                    return;
                } else {
                    attendances[i].setClockIn(now);
                    console.printResult(title, "Check-in thành công lúc: " + now, sc);
                    return;
                }
            }
        }

        for (int i = 0; i < attendances.length; i++) {
            if (attendances[i] == null) {
                attendances[i] = new Attendance(today, now, null);
                console.printResult(title, "Check-in thành công ngày " + today + " lúc " + now, sc);
                return;
            }
        }
        console.printResult(title, "Mảng chấm công đã đầy.", sc);
    }

    public void checkOut(Employee employee, Scanner sc) {
        ConsoleUI console = new ConsoleUI();
        String title = "Chấm công ra (Check-out)";

        if (employee == null) {
            console.printResult(title, "Tài khoản chưa được liên kết với nhân viên nào.", sc);
            return;
        }

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        Attendance[] attendances = employee.getAttendances();

        if (attendances == null) {
            console.printResult(title, "Danh sách chấm công chưa được khởi tạo.", sc);
            return;
        }

        for (int i = 0; i < attendances.length; i++) {
            if (attendances[i] != null && attendances[i].getDate() != null && attendances[i].getDate().equals(today)) {
                if (attendances[i].getClockIn() == null) {
                    console.printResult(title, "Bạn chưa thực hiện Check-in hôm nay!", sc);
                    return;
                }
                attendances[i].setClockOut(now);
                console.printResult(title, "Check-out thành công lúc: " + now, sc);
                return;
            }
        }
        console.printResult(title, "Không tìm thấy bản ghi check-in hôm nay. Vui lòng check-in trước.", sc);
    }

    public void viewAttendance(Employee employee, Scanner sc) {
        ConsoleUI console = new ConsoleUI();
        String title = "Lịch sử chấm công";

        if (employee == null) {
            console.printResult(title, "Tài khoản chưa được liên kết với nhân viên nào.", sc);
            return;
        }

        Attendance[] attendances = employee.getAttendances();
        if (attendances == null) {
            console.printResult(title, "Danh sách chấm công trống.", sc);
            return;
        }

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        StringBuilder table = new StringBuilder();
        table.append(String.format("%-5s | %-15s | %-12s | %-12s | %-10s%n", "STT", "Ngày", "Check-in", "Check-out", "Số giờ làm"));
        table.append("-----------------------------------------------------------------------\n");

        boolean found = false;
        int count = 1;
        for (int i = 0; i < attendances.length; i++) {
            if (attendances[i] != null && attendances[i].getDate() != null) {
                String dateStr = attendances[i].getDate().format(dateFormatter);
                String clockInStr = attendances[i].getClockIn() != null ? attendances[i].getClockIn().format(timeFormatter) : "Chưa CI";
                String clockOutStr = attendances[i].getClockOut() != null ? attendances[i].getClockOut().format(timeFormatter) : "Chưa CO";
                
                String hoursStr = "N/A";
                if (attendances[i].getClockIn() != null && attendances[i].getClockOut() != null) {
                    hoursStr = String.format("%.2f h", attendances[i].calculateWorkedHours());
                }

                table.append(String.format("%-5d | %-15s | %-12s | %-12s | %-10s%n", count++, dateStr, clockInStr, clockOutStr, hoursStr));
                found = true;
            }
        }

        if (!found) {
            table.append("Chưa có dữ liệu chấm công nào.\n");
        }

        console.printResult(title, table.toString(), sc);
    }
}
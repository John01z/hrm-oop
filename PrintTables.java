aublic static void printAttendances(Employee employee, String id, Scanner sc) {
    StringBuilder content = new StringBuilder();
    if (employee == null) {
      content.append("Khong tim thay nhan vien: ").append(id);
    } else {
      int[] w = { 20, 20, 20, 16 };
      appendHeader(content, w, "Ngay", "Gio vao", "Gio ra", "So gio lam");
      appendSeparator(content, w);
      Attendance[] rows = employee.getAttendances();
      boolean found = false;
      if (rows != null)
        for (Attendance a : rows) {
          if (a != null) {
            String inStr = a.getClockIn() != null ? String.valueOf(a.getClockIn()) : "Chua vao";
            String outStr = a.getClockOut() != null ? String.valueOf(a.getClockOut()) : "Chua ra";
            appendRow(content, w, String.valueOf(a.getDate()),
                inStr, outStr,
                String.format("%.2f", a.calculateWorkedHours()));
            found = true;
          }
        }

      if (!found)
        content.append("Khong tim thay du lieu cham cong.\n");
    }

    show("BANG CHAM CONG - " + id, content.toString(), sc);
  }

  public static void printAbsences(Employee employee, String id, Scanner sc) {
    StringBuilder content = new StringBuilder();
    if (employee == null) {
      content.append("Khong tim thay nhan vien: ").append(id);
    } else {
      int[] w = { 35, 18, 18, 16 };
      appendHeader(content, w, "Ly do", "Tu ngay", "Den ngay", "Trang thai");
      appendSeparator(content, w);
      Absence[] rows = employee.getAbsences();
      boolean found = false;
      if (rows != null)
        for (Absence a : rows) {
          if (a != null) {
            appendRow(content, w, String.valueOf(a.getReason()),
                String.valueOf(a.getFromDate()), String.valueOf(a.getToDate()),
                String.valueOf(a.getStatus()));
            found = true;
          }
        }

      if (!found)
        content.append("Khong tim thay du lieu nghi phep.\n");
    }
    show("BANG NGHI PHEP - " + id, content.toString(), sc);
  }

  public static void printResignations(Employee employee, String id, Scanner sc) {
    StringBuilder content = new StringBuilder();
    if (employee == null) {
      content.append("Khong tim thay nhan vien: ").append(id);
    } else {
      int[] w = { 45, 20, 18 };
      appendHeader(content, w, "Ly do", "Ngay", "Trang thai");
      appendSeparator(content, w);
      Resignation[] rows = employee.getResignations();
      boolean found = false;
      if (rows != null)
        for (Resignation r : rows) {
          if (r != null) {
            appendRow(content, w, String.valueOf(r.getReason()),
                String.valueOf(r.getDate()), String.valueOf(r.getStatus()));
            found = true;
          }
        }

      if (!found)
        content.append("Khong tim thay du lieu thoi viec.\n");
    }
    show("BANG THOI VIEC - " + id, content.toString(), sc);
  }

  public static void printInsurances(Employee employee, String id, Scanner sc) {
    StringBuilder content = new StringBuilder();
    if (employee == null) {
      content.append("Khong tim thay nhan vien: ").append(id);
    } else {
      int[] w = { 22, 20, 18, 18, 12 };
      appendHeader(content, w, "Ma bao hiem", "Loai", "Ngay bat dau", "Ngay ket thuc", "Ty le");
      appendSeparator(content, w);
      Insurance[] rows = employee.getInsurances();
      boolean found = false;
      if (rows != null)
        for (Insurance i : rows) {
          if (i != null) {
            appendRow(content, w, String.valueOf(i.getInsuranceNumber()),
                String.valueOf(i.getType()), String.valueOf(i.getStartDate()),
                String.valueOf(i.getEndDate()), String.format("%.2f", i.getRate()));
            found = true;
          }
        }

      if (!found)
        content.append("Khong tim thay du lieu bao hiem.\n");
    }
    show("BANG BAO HIEM - " + id, content.toString(), sc);
  }
aublic static void printAttendances(Employee employee, String id, Scanner sc) {
    StringBuilder content = new StringBuilder();
    if (employee == null) {
      content.append("Khong tim thay nhan vien: ").append(id);
    } else {
      int[] w = { 20, 20, 20, 16 };
      appendHeader(content, w, "Ngay", "Gio vao", "Gio ra", "So gio lam");
      appendSeparator(content, w);
      Attendance[] rows = employee.getAttendances();
      boolean found = false;
      if (rows != null)
        for (Attendance a : rows) {
          if (a != null) {
            String inStr = a.getClockIn() != null ? String.valueOf(a.getClockIn()) : "Chua vao";
            String outStr = a.getClockOut() != null ? String.valueOf(a.getClockOut()) : "Chua ra";
            appendRow(content, w, String.valueOf(a.getDate()),
                inStr, outStr,
                String.format("%.2f", a.calculateWorkedHours()));
            found = true;
          }
        }

      if (!found)
        content.append("Khong tim thay du lieu cham cong.\n");
    }

    show("BANG CHAM CONG - " + id, content.toString(), sc);
  }

  public static void printAbsences(Employee employee, String id, Scanner sc) {
    StringBuilder content = new StringBuilder();
    if (employee == null) {
      content.append("Khong tim thay nhan vien: ").append(id);
    } else {
      int[] w = { 35, 18, 18, 16 };
      appendHeader(content, w, "Ly do", "Tu ngay", "Den ngay", "Trang thai");
      appendSeparator(content, w);
      Absence[] rows = employee.getAbsences();
      boolean found = false;
      if (rows != null)
        for (Absence a : rows) {
          if (a != null) {
            appendRow(content, w, String.valueOf(a.getReason()),
                String.valueOf(a.getFromDate()), String.valueOf(a.getToDate()),
                String.valueOf(a.getStatus()));
            found = true;
          }
        }

      if (!found)
        content.append("Khong tim thay du lieu nghi phep.\n");
    }
    show("BANG NGHI PHEP - " + id, content.toString(), sc);
  }

  public static void printResignations(Employee employee, String id, Scanner sc) {
    StringBuilder content = new StringBuilder();
    if (employee == null) {
      content.append("Khong tim thay nhan vien: ").append(id);
    } else {
      int[] w = { 45, 20, 18 };
      appendHeader(content, w, "Ly do", "Ngay", "Trang thai");
      appendSeparator(content, w);
      Resignation[] rows = employee.getResignations();
      boolean found = false;
      if (rows != null)
        for (Resignation r : rows) {
          if (r != null) {
            appendRow(content, w, String.valueOf(r.getReason()),
                String.valueOf(r.getDate()), String.valueOf(r.getStatus()));
            found = true;
          }
        }

      if (!found)
        content.append("Khong tim thay du lieu thoi viec.\n");
    }
    show("BANG THOI VIEC - " + id, content.toString(), sc);
  }

  public static void printInsurances(Employee employee, String id, Scanner sc) {
    StringBuilder content = new StringBuilder();
    if (employee == null) {
      content.append("Khong tim thay nhan vien: ").append(id);
    } else {
      int[] w = { 22, 20, 18, 18, 12 };
      appendHeader(content, w, "Ma bao hiem", "Loai", "Ngay bat dau", "Ngay ket thuc", "Ty le");
      appendSeparator(content, w);
      Insurance[] rows = employee.getInsurances();
      boolean found = false;
      if (rows != null)
        for (Insurance i : rows) {
          if (i != null) {
            appendRow(content, w, String.valueOf(i.getInsuranceNumber()),
                String.valueOf(i.getType()), String.valueOf(i.getStartDate()),
                String.valueOf(i.getEndDate()), String.format("%.2f", i.getRate()));
            found = true;
          }
        }

      if (!found)
        content.append("Khong tim thay du lieu bao hiem.\n");
    }
    show("BANG BAO HIEM - " + id, content.toString(), sc);
  }
}

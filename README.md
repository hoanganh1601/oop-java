# Bài tập OOP Java

Kho mã gồm các bài CODE PTIT và bài luyện tập Java trên lớp. Mỗi bài nằm trong package riêng để dễ tìm, mở bằng IntelliJ IDEA và chạy độc lập khi đã có dữ liệu đầu vào phù hợp. Đây là mã để tham khảo quá trình học; việc build thành công không xác nhận bài đã được chấm đúng.

## Nội dung

- [Bài CODE PTIT](Basic/src/main/java/ptit/code/) theo chủ đề con, tra [danh mục bài CODE](docs/problem-index.md).
- [Bài trên lớp](Basic/src/main/java/ptit/classroom/) theo buổi hoặc nhóm có cùng nguồn gốc, tra [danh mục bài trên lớp](docs/classroom-index.md).
- [Cấu hình Maven](Basic/pom.xml) cho module `Basic`.

| Chủ đề con | Bài hiện có |
| --- | --- |
| Lập trình Java cơ bản | [lap_trinh_java_co_ban](Basic/src/main/java/ptit/code/lap_trinh_java_co_ban/) |
| Khai báo lớp và đối tượng | [khai_bao_lop_va_doi_tuong](Basic/src/main/java/ptit/code/khai_bao_lop_va_doi_tuong/) |
| Mảng | Chưa có bài; xem [bảng mã tham chiếu](docs/problem-index.md#bảng-mã-tham-chiếu-từ-yêu-cầu) |
| Mảng đối tượng | [mang_doi_tuong](Basic/src/main/java/ptit/code/mang_doi_tuong/) |
| Quan hệ giữa các lớp | Chưa có bài; xem [bảng mã tham chiếu](docs/problem-index.md#bảng-mã-tham-chiếu-từ-yêu-cầu) |
| Ứng dụng Java Collection | Chưa có bài; xem [bảng mã tham chiếu](docs/problem-index.md#bảng-mã-tham-chiếu-từ-yêu-cầu) |
| Vào ra file | [vao_ra_file](Basic/src/main/java/ptit/code/vao_ra_file/) |
| Xâu ký tự | Chưa có bài; xem [bảng mã tham chiếu](docs/problem-index.md#bảng-mã-tham-chiếu-từ-yêu-cầu) |

## Mở và chạy

Cài JDK 25 và Maven. Mở `Basic/` như dự án Maven trong IntelliJ IDEA, rồi chạy lớp `Main` được ghi trong danh mục. Từ thư mục gốc của kho, build bằng:

```powershell
mvn -f Basic/pom.xml compile
```

Ví dụ bài đọc đầu vào chuẩn:

```powershell
'1 0 0 3 4' | java -cp Basic/target/classes ptit.code.khai_bao_lop_va_doi_tuong.j04001.Main
```

File `.in` và các bản lưu trong `Basic/archives` là dữ liệu cá nhân dùng khi luyện tập, **không có trong repository**. Với bài đọc file, tự chuẩn bị đúng file theo đề bài và đặt **Working directory** của Run Configuration vào thư mục chứa file đó. Cột **Dữ liệu** trong danh mục cho biết tên file mà mã hiện tại mở. Một số bài chưa hoàn thành hoặc chưa có dữ liệu phù hợp; trạng thái được ghi trong danh mục.

## Thêm bài và chuẩn bị bản nộp

Tra [bảng mã tham chiếu](docs/problem-index.md#bảng-mã-tham-chiếu-từ-yêu-cầu), tạo `Basic/src/main/java/ptit/code/<chu_de>/<ma_bai_viet_thuong>/`, đặt các lớp của cùng bài trong một package và cập nhật danh mục. Nếu chưa xác minh chủ đề con, dùng `code/chua_phan_loai/<ma_bai>/`. Với bài trên lớp, dựa vào buổi học hoặc nguồn gốc; nếu chưa đủ căn cứ, dùng `classroom/chua_phan_nhom/<ten_goc>/`.

Khi nộp bài cho hệ thống chấm, tạo bản nộp theo yêu cầu cụ thể của đề về tên lớp, package và cách nhập xuất. Không ghép các bài thành một chương trình chung.

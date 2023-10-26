<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fs" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <a href="/danh-sach-yeu-thich/view-add" class="btn btn-success">ADD</a>
        <a href="/danh-sach-yeu-thich/sort" class="btn btn-primary">SORT</a>
        <c:if test="${fs:length(listDanhSachYeuThich.content) == 0}">
            <h4 class="text-center">Không có dữ liệu</h4>
        </c:if>
        <c:if test="${fs:length(listDanhSachYeuThich.content) != 0}">
            <table class="table">
                <thead>
                    <tr>
                        <td>Mã danh sách</td>
                        <td>Mã khách hàng</td>
                        <td>SDT khách hàng</td>
                        <td>Ghi chú</td>
                        <td>Trạng thái</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listDanhSachYeuThich.content}" var="dsyt">
                        <tr>
                            <td>${dsyt.ma}</td>
                            <td>${dsyt.khachHang.ma}</td>
                            <td>${dsyt.khachHang.sdt}</td>
                            <td>${dsyt.ghiChu}</td>
                            <td>${dsyt.trangThai == 1 ? "Hoạt động" : "Ngừng hoạt động"}</td>
                            <td>
                                <a href="/danh-sach-yeu-thich/delete/${dsyt.ma}" class="btn btn-danger"
                                    onclick="return confirm('Bạn có muốn xóa không ?')">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                    <c:forEach begin="0" end="${listDanhSachYeuThich.totalPages - 1}" varStatus="loop">
                        <li class="page-item">
                            <a class="page-link" href="/danh-sach-yeu-thich/hien-thi?page=${loop.begin + loop.count - 1}">
                                    ${loop.begin + loop.count}
                            </a>
                        </li>
                    </c:forEach>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </nav>
        </c:if>
    </div>
</body>
</html>
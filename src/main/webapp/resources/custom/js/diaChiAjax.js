$(document).ready(function () {

    $('#hktcBtn').click(function () {
        $('#hktcModal').modal('show');
    });
    $('#hktcBtnClose').click(function () {
        $('#hktcModal').modal('hide');
    });
    $('#noisinhBtn').click(function () {
        $('#noisinhModal').modal('show');
    });
    $('#noisinhBtnClose').click(function () {
        $('#noisinhModal').modal('hide');
    });
    $('#diachinoisinh').submit(function (event) {

        var tinh = $('#tinhns').val();
        var quanHuyen = $('#quanHuyenns').val();
        var xaPhuong = $('#xaPhuongns').val();
        var thonXom = $('#thonXomns').val();
        var json = {"tinh": tinh, "quanHuyen": quanHuyen, "xaPhuong": xaPhuong, "thonXom": thonXom};

        $.ajax({
            url: $("#diachinoisinh").attr("action"),
            data: JSON.stringify(json),
            type: "POST",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (diachi) {
                respContent = diachi.tinh + " | " + diachi.quanHuyen + " | " + diachi.xaPhuong + " | " + diachi.thonXom;
                $("#noisinhchitiet").html(respContent);
                $('#noisinhModal').modal('hide');
                var ns = document.getElementById("noiSinh");
                ns.value = diachi.id;
            }
        });

        event.preventDefault();
    });

    $('#diachihktc').submit(function (event) {

        var tinh = $('#tinhhk').val();
        var quanHuyen = $('#quanHuyenhk').val();
        var xaPhuong = $('#xaPhuonghk').val();
        var thonXom = $('#thonXomhk').val();
        var json = {"tinh": tinh, "quanHuyen": quanHuyen, "xaPhuong": xaPhuong, "thonXom": thonXom};

        $.ajax({
            url: $("#diachihktc").attr("action"),
            data: JSON.stringify(json),
            type: "POST",

            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (diachi) {
                respContent = diachi.tinh + " | " + diachi.quanHuyen + " | " + diachi.xaPhuong + " | " + diachi.thonXom;
                $("#hktcchitiet").html(respContent);
                $('#hktcModal').modal('hide');
                var hk = document.getElementById("hoKhauThuongChu");
                hk.value = diachi.id;
            }
        });

        event.preventDefault();
    });

});

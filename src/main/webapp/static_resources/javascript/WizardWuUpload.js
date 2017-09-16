//$(window).load(function () {
//});

//依傳入的自訂編號(fileUploadNum)，決定要執行哪個上傳控件，的上傳或刪除
jQuery.fn.loadUploadContent = function (fileUploadNum) {
    //调用wrap方法，为id为demo的div外层添加form元素，指定enctype为文件类型，action指定为asp.net文件
    $("#divUploadArea" + fileUploadNum).wrap("<form id='UploadForm" + fileUploadNum + "' action='http://localhost:8080/jiansw/upload/api/up' method='post' enctype='multipart/form-data'></form>");

    $("#WizardWuFileUpload" + fileUploadNum).change(function () {  //当上传文件改变时，触发事件 (不必按鈕，使用者選完圖片，就直接執行上傳的動作)
        $("#UploadForm" + fileUploadNum).ajaxSubmit({         //调用jquery.form插件的ajaxSubmit异步地提交表单
            dataType: 'text',             //返回数据类型为json
            success: function (data) {    //图片上传成功时
                //获取服务器端返回的文件数据
                data = JSON.parse(data);
                target_file_name = data.msg_data.filenames;
                console.log(target_file_name);
                alert("上传成功!");
                $('#upload_success_filenames').val(target_file_name);
            },
            error: function (xhr, errorMsg, errorThrown) {  //图片上传失败时 (後端.NET錯誤:回傳型別錯誤會進入此error區塊)
                alert('上传时发生错误');
            }
        });
    });
};
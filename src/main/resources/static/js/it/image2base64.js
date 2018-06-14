$(function () {
    //弹出文件选择器
    $("#image2base64-upload-select").click(function (e) {
        e.preventDefault();
        $("#image2base64-file").trigger("click");
    });

    $("#image2base64-upload").bind('dragenter', ignoreDrag).bind('dragover', ignoreDrag).bind("drop", function (e) {
        e.preventDefault();
        var fileList = e.originalEvent.dataTransfer.files; //获取文件对象 
        doGetBase64(fileList);
    });

    $("#image2base64-file").change(function (e) {
        e.preventDefault();
        var fileList = $("#image2base64-file")[0].files; //获取文件对象 
        doGetBase64(fileList);
    });

    function ignoreDrag(e) {
        e.originalEvent.stopPropagation();
        e.originalEvent.preventDefault();
    }

    function doGetBase64(fileList) {
        //检测是否是拖拽文件到页面的操作 
        if (fileList.length == 0) {
            return false;
        }
        //检测文件是不是图片 
        if (fileList[0].type.indexOf('image') === -1) {
            alert("您拖的不是图片！");
            return false;
        }
        var fileReader = new FileReader();
        fileReader.onload = function (e) {
            // 获取扩展名
            var extensionName = fileList[0].name.split('.');
            extensionName = extensionName[extensionName.length - 1];
            // 获取文件的base64编码
            var base64 = e.target.result;
            // 将读取 文件放置到一个img标签
            $('#image2base64-image').attr('src', base64);
            // 显示base64 
            $("#image2base64-text").text(base64);
        }
        fileReader.readAsDataURL(fileList[0]);
    }
});


# ImageUploadDemo
SpringBoot 下图片上传Demo 

## 运行

  1. 启动项目
  2. 浏览器中输入 `localhost:8080 `,上传图片，上传成功后得到图片路径
  3. `localhost:8080` + 图片路径，即可访问；或者使用`localhost:8080/getImage/ `+图片名称（不是路径）
   
# 备注
  如果上传其他类型的文件，使用文件路径打不开的话，可以使用 `getImage` 流的方式将文件输出，但是得修改一下Response 的ContentType和Header

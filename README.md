# SkyDive 
利用commons-dbutils简单的模拟了一个网盘的上传下载操作
# 上传
- 上传后文件保留在项目文件的upload里，缓存文件在temp里
# 下载
- 从项目的upload里下载，所以一定要保证文件存在才能下载，不能光看数据库的信息

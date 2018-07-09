--show_order 1开始
--module_path 深度的现实
--level从1开始显示

insert into menu (id,parent_id,label,path,component,type,module_path,used,level,show_order,icon,create_time,update_time) values (1,0,'系统设置','#','System',1,1,1,1,1,'',now(),now());
insert into menu (id,parent_id,label,path,component,type,module_path,used,level,show_order,icon,create_time,update_time) values (2,1,'菜单设置','#','MenuManage',1,1.2,1,2,1,'',now(),now());

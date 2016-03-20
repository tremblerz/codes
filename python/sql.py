import sqlite3
conn = sqlite3.connect('restaurant.db');
c=conn.cursor;
c.execute('''create table res(id integer primary key asc, name varchar(250) not null)
		''');
c.execute(''' create table menu_item(id integer primary key asc,name varchar(250) not null,price int not null,description varchar(250) not null,resid integer not null , foreign key (resid) references res(id))''');
c.commit()
c.close()

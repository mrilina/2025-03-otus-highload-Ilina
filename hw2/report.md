# Производительность индексов

## Поиск по 2 полям, имени и фамилии 
```sql
explain (select * from users where FIRSTNAME = 'Анастасия' and LASTNAME = 'Яшина' order by id);
```

![alt text](pictures/explain_2_fields_without_index.jpg)

```sql
explain analyse (select * from users where FIRSTNAME = 'Анастасия' and LASTNAME = 'Яшина' order by id);
```
![alt text](pictures/explain_analyze_2_fields_without_index.jpg)


Создание индекса
```sql
CREATE INDEX first_name_last_name_idx ON USERS USING btree(FIRSTNAME, LASTNAME);
```

Выполнение запроса с индексом
```sql
explain (select * from users where FIRSTNAME = 'Анастасия' and LASTNAME = 'Яшина' order by id);
```

![alt text](pictures/explain_2_fields_with_index.jpg)


```sql
explain analyse (select * from users where FIRSTNAME = 'Анастасия' and LASTNAME = 'Яшина' order by id);
```
![alt text](pictures/explain_analyze_2_fields_with_index.jpg)


## Поиск по 1 полю, имени
```sql
explain (select * from users where FIRSTNAME = 'Анастасия' order by id);
```

![alt text](pictures/explain_1_field_without_index.jpg)


```sql
explain analyse (select * from users where FIRSTNAME = 'Анастасия' order by id);
```

![alt text](pictures/explain_analyze_1_field_without_index.jpg)

Создание индекса
```sql
CREATE INDEX first_name_idx ON USERS USING btree(FIRSTNAME);
```

Выполнение запроса с индексом
```sql
explain (select * from users where FIRSTNAME = 'Анастасия' order by id);
```

![alt text](pictures/explain_1_field_with_index.jpg)


```sql
explain analyse (select * from users where FIRSTNAME = 'Анастасия' order by id);
```
![alt text](pictures/explain_analyze_1_field_with_index.jpg)

## Выводы
В результате создания индекса и построения плана запроса видно, что стоимость меньше, время выполнения меньше, памяти в итоге меньше, процесс 1 вместо двух.

## Нагрузочное тестирование в JMeter

Без индекса
![alt text](pictures/graph_with_index.jpg)

С индексом
![alt text](pictures/graph_without_index.jpg)
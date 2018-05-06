# Example Cassandra project

This spring boot application illustrates the use of Cassandra.

##Instalation

1. Install Datastax Opscenter

https://www.datastax.com/products/datastax-opscenter

2. Create cluster, datacenter and nodes

3. Create keyspace and table

`CREATE KEYSPACE IF NOT EXISTS store WITH REPLICATION = { 'class' : 'NetworkTopologyStrategy', 'Cassandra' : 2 };`
`CREATE TABLE store.product (id uuid PRIMARY KEY, name text, price decimal, expiry timestamp);`

4. Complete application.properties
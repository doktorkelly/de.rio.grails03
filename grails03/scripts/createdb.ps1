################################################################################
# create dbs
# run as admin:
# 1. runas /user:admin powershell
# 2. createdb.ps1
################################################################################

$pgdir="E:\Programme\PostgreSQL\9.1\bin"
$connect="-U postgres"
$username="grails03"

#done: ${pgdir}\createuser  $connect  -P $username

echo  "${pgdir}\createdb    $connect -O $username grails03_develop"
#done: & ${pgdir}\createdb  $connect -O $username grails03_develop

echo    "${pgdir}\createdb  $connect -O $username grails03_test"
# & ${pgdir}\createdb       $connect -O $username grails03_test

echo  "${pgdir}\createdb    $connect -O $username grails03"
# & ${pgdir}\createdb       $connect -O $username grails03
	



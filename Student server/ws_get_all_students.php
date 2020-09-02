<?php

include "connection.php";
$arr=array();
$rs=mysqli_query($link,"select * from student");
while($obj=mysqli_fetch_object($rs))
{
    $arr[]=$obj;
}

echo '{"data":'.json_encode($arr).'}';

?>
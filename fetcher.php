<?php

require 'connect.php';
$tableName=$_POST["tableName"];//To be received
$query="select * FROM $tableName";

if($result = mysqli_query($con,$query)){

while ($row = mysqli_fetch_row($result)) {
    echo "\n";
    $length=count($row);
    for($i=0;$i<$length;$i++){
        echo "$row[$i]	";
    }
  }
}

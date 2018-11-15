<?php
	include "connect.php";
	$mangspnoibat = array();
	$query = "SELECT * FROM sanpham ORDER BY ID ASC LIMIT 8";
	$data = mysqli_query($conn,$query);
	while ($row = mysqli_fetch_assoc($data)){
		array_push($mangspnoibat, new Sanphamnoibat(
			$row['id'],
			$row['tensanpham'],
			$row['giasanpham'],
			$row['hinhanhsanpham'],
			$row['motasanpham'],
			$row['idsanpham']));
	}
	echo json_encode($mangspnoibat);



	class Sanphamnoibat{
		function Sanphamnoibat($id,$tensp,$giasp,$hinhanhsp,$motasp,$idsanpham){
			$this->id=$id;
			$this->tensp=$tensp;
			$this->giasp=$giasp;
			$this->hinhanhsp=$hinhanhsp;
			$this->motasp=$motasp;
			$this->idsanpham=$idsanpham;
		
		}
	}
?>
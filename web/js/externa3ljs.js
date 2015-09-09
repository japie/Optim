// JavaScript Document

function ff()
{
	
    var mydata=JSON.parse(allsuccesion);
	$(".total_positions").text("("+mydata.length+")");
	
//sort list//	
	var selected = document.getElementById('filtering').value;
		if(selected=='Notice')// sort by notice
	{
	function sortByKey(array, key) {
    return array.sort(function(a, b) {
        var x = a[key]; var y = b[key];
        return ((x < y) ? -1 : ((x > y) ? 1 : 0));
    });
}

mydata = sortByKey(mydata, 'NoticeType');


	}
	else if(selected=='Positions')//sort by position
	{
		
	function sortByKey(array, key) {
    return array.sort(function(a, b) {
        var x = a[key]; var y = b[key];
        return ((x < y) ? -1 : ((x > y) ? 1 : 0));
    });
}

mydata = sortByKey(mydata, 'NoticeType');
mydata.reverse();
	}
	else
	{
		//alert("Not working yet");
		}//end json sorting
	
//end sort list//
	var totalleaving=0,totalroles=0;
	for(var i=0;i<mydata.length;i++)
	{
		if(mydata[i].NoticeType=='Notice')
		{
	$('.outline_roles').clone().insertBefore('div.outline_roles').attr('class',i).css({'margin-top':'5px','background-color':'white','height':'80px'});
	$('.'+i).find(".roletype").text(mydata[i].Heading);
	$('.'+i).find(".projectname").text(mydata[i].Projects);
	$('.'+i).find(".experience").text(mydata[i].info);
	$('.'+i).find(".contracttype").text(mydata[i].NoticeType);
	$('.'+i).find(".posted_date").text("Posted Date ("+mydata[i].PostDate+")");
	$('.'+i).find(".role_status").css('background-color','#FFC200');
	$('.'+i).find("#view_personss").attr('id',mydata[i].ID);
	totalleaving++;
	if(i==mydata.length-1)
	{$('.outline_roles').remove();}
		}
		else 
		{
$('.outline_roles').clone().insertBefore('div.outline_roles').attr('class',i).css({'margin-top':'5px','background-color':'white','height':'80px'});
	$('.'+i).find(".roletype").text(mydata[i].Heading);
	$('.'+i).find(".projectname").text(mydata[i].Projects);
	$('.'+i).find(".experience").text(mydata[i].info);
	$('.'+i).find(".contracttype").text(mydata[i].NoticeType);
	$('.'+i).find(".posted_date").text("Posted Date ("+mydata[i].PostDate+")");
	$('.'+i).find(".role_status").css('background-color','red');
	$('.'+i).find("#view_personss").attr('id',mydata[i].ID);
	totalroles++;
	if(i==mydata.length-1)
	{$('.outline_roles').remove();}
	}
	
	
	}// end main for loop
	$(".numberofpeopleleaving").text("("+totalleaving+")");
	$(".numberofroles").text("("+totalroles+")");
	
	
}//end main json funtion
//XXXXXXXXXXXXXXXXXXXXXX end main successionplan  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//

//XXXXXXXXXXXXXXXXXXXXXX Training Plan Begin   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//
    var completed=0;
	var intraining=0;
	var nottrained=0;
	var notdefined=0;

function trainingplan(){
	
	var tplan=JSON.parse(TrainingPlan);

$('.testing').css('visibility','visible');
		
	var del=0;
	for(i=0;i<tplan.length;i++)
	{
		
		var numberofskillscells=(document.getElementById('skillsname').cells.length);
		while(numberofskillscells!=1)
		{
			document.getElementById("skillsname").deleteCell(-1);
			numberofskillscells--;
			}//erase skills
		var del=0;
		
				while(del!=tplan.length)
			{
			   $('.'+del).remove();
			   del++;
			}//erase list names
		if(document.getElementById('filtering').options.length!=tplan.length)
		{
		$("#filtering").append('<option value="i">'+tplan[i].Role+'</option>');
		}
		
	}//end initialise loop
	var a=document.getElementById("filtering").selectedIndex;
	var looparray=a;
	for(i=looparray;i<looparray+1;i++)
	{
		
		
     for(k=0;k<tplan[i].EmployeeTrainingInfoList.length;k++)
	{ 
		 $('.testing').clone().insertBefore('.testing').attr('class',k);
	 $('.'+k).find(".name").attr('class','name'+k);

     $('.'+k).find('.name'+k).text(tplan[i].EmployeeTrainingInfoList[k].Name+ " " +tplan[i].EmployeeTrainingInfoList[k].Surname);
	 
	  for(z=0;z<tplan[i].EmployeeTrainingInfoList[k].QualificationsList.length;z++)
	  {
		  $('#TrainingTable').find('.frole').text(tplan[i].Role).attr('colspan',tplan[i].EmployeeTrainingInfoList[k].QualificationsList.length+1);
		  $('#TrainingTable').find('.trainingmodules').attr('colspan',tplan[i].EmployeeTrainingInfoList[k].QualificationsList.length);
          $('#TrainingTable').find('.'+k).append('<td>'+tplan[i].EmployeeTrainingInfoList[k].QualificationsList[z].QualificationStatus+'</td>');
		  var rowCount = $('.skills td').length;
		  if(rowCount!=tplan[i].EmployeeTrainingInfoList[k].QualificationsList.length+1)
		  {
		  $('.skills').append('<td class="Qual">'+tplan[i].EmployeeTrainingInfoList[k].QualificationsList[z].QualificationTitle+'</td>').css('color','red');
		  }
		  			if(tplan[i].EmployeeTrainingInfoList[k].QualificationsList[z].QualificationStatus=='In-training')
					{intraining++;}
					else if(tplan[i].EmployeeTrainingInfoList[k].QualificationsList[z].QualificationStatus=='complete')
					{completed=100;}
					else if(tplan[i].EmployeeTrainingInfoList[k].QualificationsList[z].QualificationStatus=='Not-Trained')
					{nottrained++;}
					else
					{notdefined++;}
	}// loop qualifications

	}//loop employee names
$('.testing').css('visibility','hidden');
 
		}// outer for loop
	
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX stats  XXXXXXXXXXXXXXXXXXXXXX//


	
}//end main training function
//XXXXXXXXXXXXXXXXXXXXXXXXXXXX END MAIN TRAINING PLAN   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//



//XXXXXXXXXXXXXXXXXXXXXXXXXXXX Projects start method XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//

function projects()
{
	var pplan=JSON.parse(ProjectOver);
	$('.numberofprojects').text("("+pplan.length+")");
	for(i=0;i<pplan.length;i++)
	{
	
	$('.project_box').clone().insertBefore('div.project_box').attr('class',i).css({'margin-top':'2px','height':'65px','border':'1px solid #ccc','background-color':'white'});
	$('.'+i).find(".projectname").text(pplan[i].ProjectName).css({'color':'#333','font-size':'20px'});
	$('.'+i).find(".cnotify").text(pplan[i].Capacity);
	$('.'+i).find(".snotify").text(pplan[i].ProjectPhases);
	$('.'+i).find(".notify").text(pplan[i].Status);
	$('.'+i).find(".enddate").text(pplan[i].EndDate);
	//$('#'+i).find(".view_proj").attr("value",pplan[i].ProjectID);
	$('.'+i).find("#clickme").attr('value',pplan[i].ProjectID);
	
	}
	$('.project_box').remove();
}// end main function
//XXXXXXXXXXXXXXXXXXXXXXXXXXXX Projects end method XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/

//********project id injection

function g(cc){
 alert(cc);
	
	
}



function project(proJName){
	
	var hmap=JSON.parse(NewHeatMap);
	var functionarray=[];
	var uniqueNames=[];
	 
      $('.levl').remove();
	   $('.rwls').remove();
	   $('.rawls').remove();
	  
	// mappaing table data
	
	for(a=0;a<hmap.length;a++)
	{
		
		if(hmap[a].ProjectName == proJName)
	for(i=0;i<hmap[a].mainHeatMap.length;i++)
	{
		

			$('.'+proJName).append('<tr class="levl"><td>'+hmap[a].mainHeatMap[i].Level+'</td></tr>');
			
		
		for(k=0;k<hmap[a].mainHeatMap[i].RolesCol.length;k++)
		{
			functionarray.push(hmap[a].mainHeatMap[i].RolesCol[k].Phase);

			}//end inner forloop

		
		}//end second forloop
		
		
	
	}// end main for loop
	
	// create first row of the heatmap
	var checknodublicate=0;    // hide 1st col of all levels...to unhide change the value to 0.
	while(checknodublicate!=functionarray.length)
	{
	$.each(functionarray, function(i, el){
    if($.inArray(el, uniqueNames) === -1) uniqueNames.push(el);
});
	checknodublicate++;
	}
	checknodublicate=0; //also change to 0 to unhide all col's in all levels..
	
	while(checknodublicate!=uniqueNames.length)
	{
		$('.roles').append('<td class ="rwls">'+uniqueNames[checknodublicate]+'</td>');
		$('.levl').append('<td style="background-color:#C61A2B"></td>');
		checknodublicate++;
		}
		
	//end creating first row ofthe heatmap
		
for(b=0;b<hmap.length;b++)
	{
		
	for(j=0;j<hmap[b].mainHeatMap.length;j++)
	{
		
		
		for(l=0;l<hmap[b].mainHeatMap[j].RolesCol.length;l++)
		{
			//do things here;
			var loop=1;
			
			
			  while(loop!=document.getElementById('roless').getElementsByTagName('td').length)
			 {
				 

				if($('.'+proJName+' tr').eq(0).find('td').eq(loop).text()==hmap[b].mainHeatMap[j].RolesCol[l].Phase)
				{
					var numberofrows =0;
					while(numberofrows!=$('.'+proJName+' tr').length)
					 {
					   if($('.'+proJName+' tr').eq(numberofrows).find('td').eq(0).text()==hmap[b].mainHeatMap[j].Level)
					   {
						   //$('.heatmap_table').append('<td>xx<td>').eq(numberofrows).eq(loop);
	if( hmap[b].mainHeatMap[j].RolesCol[l].Employees.length == 1){ 
	
					if( hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Status =="Green"){ //color coding base on status >green,amber,red 
					
         $("."+proJName).find("tr").eq(numberofrows).find("td").eq(loop).append("<a class='tooltip' href='#' onClick='show(this.id)'id='"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].EmployeeId+"'>"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Name+"  <span class='classic'>Click to view "+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Name+"'s profile</span></a>");

				$("."+proJName).find("tr").eq(numberofrows).find("td").eq(loop).css("background-color",'#187616');	
				
							}else if( hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Status =="Amber"){
								   //Ember
	$("."+proJName).find("tr").eq(numberofrows).find("td").eq(loop).append("<a class='tooltip' href='#' onClick='show(this.id)'id='"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].EmployeeId+"'>"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Name+"<img src='img/exclamation_silver_2.png'  width='15' height='15' class='noti_icon' style=' margin-left:3px;' /> <span class='classic'>Click to view "+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Name+"'s profile</span></a>");
				$("."+proJName).find("tr").eq(numberofrows).find("td").eq(loop).css("background-color",'#F1A32E');
							
								}else{
									   //RED
	$("."+proJName).find("tr").eq(numberofrows).find("td").eq(loop).append("<a class='tooltip' href='#'  onClick='show(this.id)'id='"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].EmployeeId+"'>"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Name+"<img src='img/exclamation_silver.png'  width='15' height='15' class='noti_icon' style='opacity:1; margin-left:3px'/>"+"   <span class='classic'>Click to view "+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Name+"'s profile</span></a>");
				$("."+proJName).find("tr").eq(numberofrows).find("td").eq(loop).css("background-color",'#C61A2B');
									
									}
	
		
		 
		
		}else{ // if employee length > 1, stack them down here within their cell...
				    
	                   for(var x = 0; x< hmap[b].mainHeatMap[j].RolesCol[l].Employees.length; x++){
if( hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Status =="Green"){ //color coding base on status >green,amber,red 

$("."+proJName).find("tr").eq(numberofrows).find("td").eq(loop).append("<a class='tooltip' href='#' onClick='show(this.id)'id='"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].EmployeeId+"'>"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Name+" <span class='classic'>Click to view "+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Name+"'s profile</span></a>"+"</br>"); //this cell has flag, name and tooltip properties of a cell


				$("."+proJName).find("tr").eq(numberofrows).find("td").eq(loop).css("background-color",'#187616');	
				
							}else if( hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Status =="Amber"){
								   //Ember
$("."+proJName).find("tr").eq(numberofrows).find("td").eq(loop).append("<a class='tooltip' href='#'  onClick='show(this.id)'id='"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].EmployeeId+"'>"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Name+"<img src='img/exclamation_silver_2.png'  width='15' height='15' class='noti_icon' style=' margin-left:3px;' />"+"  <span class='classic'>Click to view "+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Name+"'s profile</span></a>"+"<br/>");  //this cell has flag, name and tooltip properties of a cell


				$("."+proJName).find("tr").eq(numberofrows).find("td").eq(loop).css("background-color",'#F1A32E');
				
							
								}else{
									   //RED
$("."+proJName).find("tr").eq(numberofrows).find("td").eq(loop).append("<a class='tooltip' href='#'  onClick='show(this.id)'id='"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].EmployeeId+"'>"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Name+"<img src='img/exclamation_silver.png'  width='15' height='15' class='noti_icon' style='opacity:1; margin-left:3px'  />"+"  <span class='classic'>Click to view "+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Name+"'s profile</span></a>"+"<br/>");
				$("."+proJName).find("tr").eq(numberofrows).find("td").eq(loop).css("background-color",'#C61A2B');
									
									}
						}
				
				}
							//x.append('<td></td>');
							
						   }
						
						numberofrows++;
						}
					   
					
					}
				
			   loop++;
			   }//end while loop
			   
			}//end inner forloop

		
		}//end second forloop
		
		
	
	}// end main for loop	
	}		
	//-----------new project table
//function for on click ALL htmap

function allLevl(){
	var hmap=JSON.parse(NewHeatMap);
	var functionarray=[];
	var uniqueNames=[];
	 $('.rwls').remove();
	$('.rawls').remove();
	for(a=0;a<hmap.length;a++)
	{
		
	for(i=0;i<hmap[a].mainHeatMap.length;i++)
	{

			//$('.heatmap_table').append('<tr class="lev"><td>'+hmap[a].mainHeatMap[i].Level+'</td></tr>');
					
		for(k=0;k<hmap[a].mainHeatMap[i].RolesCol.length;k++)
		{
			functionarray.push(hmap[a].mainHeatMap[i].RolesCol[k].Phase);

			}//end inner forloop

		}//end second forloop

	}// end main for loop

		// create first row of the heatmap
	var checknodublicate=0;    // hide 1st col of all levels...to unhide change the value to 0.
	while(checknodublicate!=functionarray.length)
	{
	$.each(functionarray, function(i, el){
    if($.inArray(el, uniqueNames) === -1) uniqueNames.push(el);
});
	checknodublicate++;
	}
	checknodublicate=0; //also change to 0 to unhide all col's in all levels..
	
	while(checknodublicate!=uniqueNames.length)
	{
		$('.roles').append('<td class="rawls">'+uniqueNames[checknodublicate]+'</td>');
		//$('.lev').append('<td style="background-color:#C61A2B"></td>');
		checknodublicate++;
		}
		
	//end creating first row ofthe heatmap
	
	}
	
//XXXXXXXXXXXXXXXXXXXXXXXXXXXX Heatmap start method XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/

window.onload = function()
{
	

	var hmap=JSON.parse(NewHeatMap);
	var functionarray=[];
	var uniqueNames=[];
	
    //tabs----------
	
	var tabs = $( "#tabs" );
var ul = tabs.find( "ul.tabs_1" );
	
	for(var t = 0 ; t< hmap.length; t++){

 $('<li onClick="project(this.id)" id='+hmap[t].ProjectName+'><input type="radio" checked name="tabs" id="tab_'+t+'"><label  for="tab_'+t+'">'
											+hmap[t].ProjectName+'</label>'
											+'<div id="tab-content_"'+t+' class="tab_content">'
											+'<table  align="center" width="100%" id="ht" class='+hmap[t].ProjectName+'>'
											+'<tr id="roless" class="roles"><td></td></tr></table>'
											+'</div></li>').appendTo( ul );
		} 
	// mappaing table data
	
	for(a=0;a<hmap.length;a++)
	{
		
	for(i=0;i<hmap[a].mainHeatMap.length;i++)
	{
		

	$('.heatmap_table').append('<tr class="lev" ><td>'+hmap[a].mainHeatMap[i].Level+'</td></tr>');
			
		
		for(k=0;k<hmap[a].mainHeatMap[i].RolesCol.length;k++)
		{
			functionarray.push(hmap[a].mainHeatMap[i].RolesCol[k].Phase);

			}//end inner forloop

		
		}//end second forloop
		
		
	
	}// end main for loop
	
	// create first row of the heatmap
	var checknodublicate=0;    // hide 1st col of all levels...to unhide change the value to 0.
	while(checknodublicate!=functionarray.length)
	{
	$.each(functionarray, function(i, el){
    if($.inArray(el, uniqueNames) === -1) uniqueNames.push(el);
});
	checknodublicate++;
	}
	checknodublicate=0; //also change to 0 to unhide all col's in all levels..
	
	while(checknodublicate!=uniqueNames.length)
	{
		$('.roles').append('<td class="rawls">'+uniqueNames[checknodublicate]+'</td>');
		$('.lev').append('<td style="background-color:#C61A2B"></td>');
		checknodublicate++;
		}
		
	//end creating first row ofthe heatmap
		
for(b=0;b<hmap.length;b++)
	{
		
	for(j=0;j<hmap[b].mainHeatMap.length;j++)
	{
		
		
		for(l=0;l<hmap[b].mainHeatMap[j].RolesCol.length;l++)
		{
			//do things here;
			var loop=1;
			
			
			  while(loop!=document.getElementById('roless').getElementsByTagName('td').length)
			 {
				 

				if($('#ht tr').eq(0).find('td').eq(loop).text()==hmap[b].mainHeatMap[j].RolesCol[l].Phase)
				{
					var numberofrows =0;
					while(numberofrows!=$('.heatmap_table tr').length)
					 {
					   if($('#ht tr').eq(numberofrows).find('td').eq(0).text()==hmap[b].mainHeatMap[j].Level)
					   {
						   //$('.heatmap_table').append('<td>xx<td>').eq(numberofrows).eq(loop);
	if( hmap[b].mainHeatMap[j].RolesCol[l].Employees.length == 1){ 
	
					if( hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Status =="Green"){ //color coding base on status >green,amber,red 
					
         $(".heatmap_table").find("tr").eq(numberofrows).find("td").eq(loop).append("<a class='tooltip' href='#' onClick='show(this.id)'id='"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].EmployeeId+"'>"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Name+"  <span class='classic'>Click to view "+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Name+"'s profile</span></a>");

				$(".heatmap_table").find("tr").eq(numberofrows).find("td").eq(loop).css("background-color",'#00CC66');	
				
							}else if( hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Status =="Amber"){
								   //Ember
	$(".heatmap_table").find("tr").eq(numberofrows).find("td").eq(loop).append("<a class='tooltip' href='#' onClick='show(this.id)'id='"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].EmployeeId+"'>"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Name+"<img src='img/exclamation_silver_2.png'  width='15' height='15' class='noti_icon' style=' margin-left:3px;' /> <span class='classic'>Click to view "+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Name+"'s profile</span></a>");
				$(".heatmap_table").find("tr").eq(numberofrows).find("td").eq(loop).css("background-color",'#F1A32E');
							
								}else{
									   //RED
	$(".heatmap_table").find("tr").eq(numberofrows).find("td").eq(loop).append("<a class='tooltip' href='#'  onClick='show(this.id)'id='"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].EmployeeId+"'>"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Name+"<img src='img/exclamation_silver.png'  width='15' height='15' class='noti_icon' style='opacity:1; margin-left:3px'/>"+"   <span class='classic'>Click to view "+hmap[b].mainHeatMap[j].RolesCol[l].Employees[0].Name+"'s profile</span></a>");
				$(".heatmap_table").find("tr").eq(numberofrows).find("td").eq(loop).css("background-color",'#C61A2B');
									
									}
	
		
		 
		
		}else{ // if employee length > 1, stack them down here within their cell...
				    
	                   for(var x = 0; x< hmap[b].mainHeatMap[j].RolesCol[l].Employees.length; x++){
if( hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Status =="Green"){ //color coding base on status >green,amber,red 

$(".heatmap_table").find("tr").eq(numberofrows).find("td").eq(loop).append("<a class='tooltip' href='#' onClick='show(this.id)'id='"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].EmployeeId+"'>"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Name+" <span class='classic'>Click to view "+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Name+"'s profile</span></a>"+"</br>"); //this cell has flag, name and tooltip properties of a cell


				$(".heatmap_table").find("tr").eq(numberofrows).find("td").eq(loop).css("background-color",'#00CC66');	
				
							}else if( hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Status =="Amber"){
								   //Ember
$(".heatmap_table").find("tr").eq(numberofrows).find("td").eq(loop).append("<a class='tooltip' href='#'  onClick='show(this.id)'id='"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].EmployeeId+"'>"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Name+"<img src='img/exclamation_silver_2.png'  width='15' height='15' class='noti_icon' style=' margin-left:3px;' />"+"  <span class='classic'>Click to view "+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Name+"'s profile</span></a>"+"<br/>");  //this cell has flag, name and tooltip properties of a cell


				$(".heatmap_table").find("tr").eq(numberofrows).find("td").eq(loop).css("background-color",'#F1A32E');
				
							
								}else{
									   //RED
$(".heatmap_table").find("tr").eq(numberofrows).find("td").eq(loop).append("<a class='tooltip' href='#'  onClick='show(this.id)'id='"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].EmployeeId+"'>"+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Name+"<img src='img/exclamation_silver.png'  width='15' height='15' class='noti_icon' style='opacity:1; margin-left:3px'  />"+"  <span class='classic'>Click to view "+hmap[b].mainHeatMap[j].RolesCol[l].Employees[x].Name+"'s profile</span></a>"+"<br/>");
				$(".heatmap_table").find("tr").eq(numberofrows).find("td").eq(loop).css("background-color",'#C61A2B');
									
									}
						}
				
				}
							//x.append('<td></td>');
							
						   }
						
						numberofrows++;
						}
					   
					
					}
				
			   loop++;
			   }//end while loop
			   
			}//end inner forloop

		
		}//end second forloop
		
		
	
	}// end main for loop
		

}//end main function




//XXXXXXXXXXXXXXXXXXXXXXXXXXXX End method XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/

//---------pass value from one page to another -----------------//
  function processForm()
  {
	var proj=JSON.parse(profile);

    var parameters = location.search.substring(1).split("&");
    var temp = parameters[0].split("=");
    l = unescape(temp[1]);
    //-------recieve project id from project list
	$('#dept').text('');
	 $('#projectName').text('');
	  $('#actualAmount').text('');
	  $('#plannedAmount').text('');
	  $('#capacity').text('');
	  $('#proj_status').text('');
	  $('#pjnames').text('');
    //for(var x = 0; x< proj.length; x++){
		 
	  if( proj.projectId == l )
	  {
	
	 $('#projectName').text(proj.ProjectName);
	  $('#actualAmount').text(proj.ActualProjectCost);
	  $('#plannedAmount').text(proj.ProjectPlanedCost);
	  $('#capacity').text(proj.Capacity);
	  $('#proj_status').text(proj.Status);
	  $('#pjnames').text(proj.ProjectManager);
	  drawbar(proj.StartDate,proj.EndDate); //method from pBar.js
	  //alert(proj.ProjectTeamList.length);
	  for(k=0;k<proj.ProjectTeamList.length;k++)
	  {
		 
		  $('.personX').clone().insertBefore('div#TeamList').attr('class',k).css('background-color','#7094B8');
		  $('.'+k).find('.name').text(proj.ProjectTeamList[k].NameAndSurname);
		  $('.'+k).find('#PlayerRole').text(proj.ProjectTeamList[k].JobTitle);
		   
		 }//end member display
		  
		  $('.personX').remove();
			}// end if statement
		 
		// }// end for loop
	
  }


////XXXXXXXXXXXXXXXXXXXXXXXXXXXX START HIRING   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//

function hiringp(){
	
	var data=JSON.parse(Hiringf);
	for(i=0;i<data.length;i++){
		
$(".hire_table").append("<tr><td>"+data[i].RoleName+"</td><td>"+data[i].Level+"</td><td>"+data[i].ProjectName+"</td><td>"+data[i].Expirience+"</td><td>"+data[i].EmploymentType+"</td><td>"+data[i].NumberOfHiring+"</td><td>"+data[i].NumberOfHired+"</td><td>"+data[i].NumberOfRejected+"</td></tr>");
	

	}//end role display
	
	
}//end maun function

function printData()
{
   var divToPrint=document.getElementById("hire_table");
   newWin= window.open("");
   newWin.document.write(divToPrint.outerHTML);
   newWin.print();
   newWin.close();
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXX CONNECT CAPACITY PLAN   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//


function capacityplan(){

var capdata = JSON.parse(Capacityp)

	for(i=2;i<capdata.length;i++){
		
$(".table-style-three").append("<tr><td>"+capdata[i].Phases+"</td><td>"+capdata[i].StartDate+"</td><td>"+capdata[i].EndDate+"</td><td>"+capdata[i].EstimatedManDays+"</td><td>"+capdata[i].ActualManDays+"</td><td>"+capdata[i].NumberOfEmployees+"</td></tr>");
	

	}
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXX END CAPACITY PLAN   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//

//XXXXXXXXXXXXXXXXXXXXXXXXXXXX PRINTING FUNCTION   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//


function printDiv(divName) {
	
     var printContents = document.getElementById(divName).innerHTML;
     var originalContents = document.body.innerHTML;

     document.body.innerHTML = printContents;

     window.print();
	 

     document.body.innerHTML = originalContents;
}
//XXXXXXXXXXXXXXXXXXXXXXXXXXXX END PRINTING FUNCTION  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//


//XXXXXXXXXXXXXXXXXXXXXXXXXXXX successor display XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//
function displaysuccessors()
{
	var sdata=JSON.parse(ListSuccessors);
    var parameters = location.search.substring(1).split("&");
    var temp = parameters[0].split("=");
    l = unescape(temp[1]);
    //alert(l);
	$('.current_role').text(sdata.JobTitle);
	$('.experience').text(sdata.ExpirienceAndQualification);
	$('#prede_name').text(sdata.PredeccessorNameAndSurname);
	$('#note_placed').text(sdata.NoticeDate);
	for(i=0;i<sdata.SuccessorsList.length;i++)
	{
		$('.wrap_succ_box').clone().insertAfter('div.wrap_succ_box').attr('class',i);
		$('.'+i).find("#success_description").text(sdata.SuccessorsList[i].NameAndQualification);
		$('.'+i).find(".success_status").text(sdata.SuccessorsList[i].JobTitleAndExpirience+" year(s)");
		$('.'+i).find(".match").text(sdata.SuccessorsList[i].MatchPercentage);
		
		}
}
	
//XXXXXXXXXXXXXXXXXXXXXXXXXXXX End successor XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//
   


//XXXXXXXXXXXXXXXXXXXXXXXXXXXX capacity landing start XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//

function capacitylanding()
{
	var mydata=JSON.parse(CapacityLanding);

for(var i=0;i<mydata.length;i++)
{
$('#projectname').text(mydata[i].ProjectName).css({'color':'white','font-family':'Segio UI','font-weight':'lighter','font-size':'20px'});
$('#projectteam').text(mydata[i].ProjectTeam).css({'color':'grey','font-family':'Segio UI','font-weight':'lighter','font-size':'20px'});

$('.projects_box').clone().insertAfter($('div.projects_box:last')).prop({'class':'projects_box'+i}).css({'height':'80px','background-color':
'#C6362f','display':'inline-block','width':'200px','margin-left':'10px','margin-top':'5px','cursor':'pointer'});


}// end for loop

	}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXX capacity landing end XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//




//XXXXXXXXXXXXXXXXXXXXXXXXXXXX CONNECT CAPACITY PLAN   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//

//
function capacityplan(){

var proj_array=[];
var uniqueProj=[];
	
var capdata = JSON.parse(capacity);

$('.list_header a').text('');
$('.list_proj').text('');
$('.list_header a').text('Projects('+capdata.length+")");
	for(i=0;i<capdata.length;i++){
    
  for(var x = 0; x< capdata[i].capacityMain.length; x++){ 
  proj_array.push(capdata[i].capacityMain[x].ProjectName);
   
   }// close for loop
	}//close main for loop
	
	var checknodublicate=0;    // sorting and removing dubplicates...
	while(checknodublicate!=proj_array.length)
	{
	$.each(proj_array, function(i, el){
    if($.inArray(el, uniqueProj) === -1) uniqueProj.push(el);
});
	checknodublicate++;
	}
	checknodublicate=0; //also change to 0 to unhide all col's in all levels..
	var setId =null;
	while(checknodublicate!=uniqueProj.length)
	{

         for(i=0;i<capdata.length;i++){
            
			  for(var x = 0; x< capdata[i].capacityMain.length; x++){ 
			  proj_array.push(capdata[i].capacityMain[x].ProjectName);
			   setId =capdata[i].capacityMain[x].Proj_id;
			   }// close for loop
	
			 $('.list_proj').append('<div class="proj_wrap"><input type="radio" name="radio" onClick="capprojId(this.id)" id="'+setId+'"  class="radio"/>'
	+'<label  class="proj_value" for="'+setId+'" id='+setId+'>'+uniqueProj[checknodublicate]+'</label></div>');
		checknodublicate++;
		}
		capprojId( setId );
		}//close main for loop
		
}
// another function for capacity
function capprojId( id ){
	var capdata = JSON.parse(capacity);
	$('#proj_name').text('');
	 $('#proj_name').append($('label#'+id).text());
	 $(".cap_data").remove();
	for(i=0;i<capdata.length;i++){
  for(var x = 0; x< capdata[i].capacityMain.length; x++){ 
       if(capdata[i].capacityMain[x].Proj_id == id)
  $(".table-style-three").append("<tr class='cap_data'><td>"+capdata[i].capacityMain[x].Phases+"</td><td>"+capdata[i].capacityMain[x].StartDate+"</td><td>"+capdata[i].capacityMain[x].EndDate+"</td><td>"+capdata[i].capacityMain[x].EstimatedManDays+"</td><td>"+capdata[i].capacityMain[x].ActualManDays+"</td><td>"+capdata[i].capacityMain[x].NumberOfEmployees+"</td></tr>");
  
    

   }// close for loop
	}//close main for loop
	
	}
 
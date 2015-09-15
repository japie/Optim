// JavaScript Document

function GetCellValues() {
        var table = document.getElementById('ht');
        for (var r = 0, n = table.rows.length; r < n; r++) {
            for (var c = 0, m = table.rows[r].cells.length; c < m; c++) {
                if(table.rows[r].cells[c].innerHTML==='')
				{
					$(".heatmap_table").find("tr").eq(r).find("td").eq(c).css('background-color','white');
					
					}
            }
        }
    }
	
successtypevar;
function ff()
{
alert(window.successtypevar);	
	    $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "Login"
            },
            success : function(responsejson) {
               
    $('#nameAndSurname').text(responsejson);
    
   var parameters = location.search.substring(1).split("&");//
    var temp = parameters[0].split("=");
    l = unescape(temp[1]);
	
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "OpenRolesAndNoticeSuc",
				accessId : l
            },
            success : function(responseJson) {
               
		var mydata=JSON.parse(responseJson);	   
             // mydata=responseJson;
              
	$(".total_positions").text(mydata.length);
	
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
		
		}//end json sorting
	
//end sort list//
	var totalleaving=0,totalroles=0;
	for(var i=0;i<mydata.length;i++)
	{
		if(document.getElementById("search").value=='')
		{
		
		if(mydata[i].NoticeType=='Notice')
		{
	$('.outline_roles').clone().insertBefore('div.outline_roles').attr('class',i).css({'margin-top':'30px','background-color':'white'});
	$('.'+i).find(".roletype").text(mydata[i].Heading);
	$('.'+i).find(".projectname").text(mydata[i].Projects);
	$('.'+i).find(".experience").text(mydata[i].info);
	$('.'+i).find(".contracttype").text(mydata[i].NoticeType);
	$('.'+i).find(".posted_date").text(mydata[i].PostDate);
	$('.'+i).find(".role_status").css('background-color','#FFC200');
	$('.'+i).find("#view_personss").attr('value',mydata[i].ID);
	$('.'+i).css('display','block');
	totalleaving++;
	if(i==mydata.length-1)
	{$('.outline_roles').remove();}
		}
		else 
		{
$('.outline_roles').clone().insertBefore('div.outline_roles').attr('class',i).css({'margin-top':'30px','background-color':'white'});
	$('.'+i).find(".roletype").text(mydata[i].Heading);
	$('.'+i).find(".projectname").text(mydata[i].Projects);
	$('.'+i).find(".experience").text(mydata[i].info);
	$('.'+i).find(".contracttype").text(mydata[i].NoticeType);
	$('.'+i).find(".posted_date").text(mydata[i].PostDate);
	$('.'+i).find(".role_status").css('background-color','red');
	$('.'+i).find("#view_personss").attr('value',mydata[i].ID);
	$('.'+i).css('display','block');
	totalroles++;
	if(i==mydata.length-1)
	{$('.outline_roles').remove();}
	}
	
		}
		else
		{
			
							if(mydata[i].Heading.toLowerCase().startsWith(document.getElementById("search").value.toLowerCase())===true)
						{
							$('.'+i).css('display','block');
                                                        //$("#Noresult").css('display','none');
                                                      
							}
							  else
							    {
                                                              //  $("#Noresult").css('display','block');  
                                                              //$("#Noresult").text("No results for "+'"'+document.getElementById("search").value+'"');
									$('.'+i).css('display','none');
									}
			
			}
	
	
	}// end main for loop
	$(".numberofpeopleleaving").text(totalleaving);
	$(".numberofroles").text(totalroles);
	
	
//end main json funtion
//XXXXXXXXXXXXXXXXXXXXXX end main successionplan  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//


   
       
            }
    });
   
       
            }
    });
	
        }
//XXXXXXXXXXXXXXXXXXXXXX Training Plan Begin   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//

    var completed=0;
	var intraining=0;
	var nottrained=0;
	var notdefined=0;

function trainingplan(){
 $('#loader_handle').html("<span>Retrieving Data...</span>"+'<img src="img/ajax-loader.gif" style="margin-top:-28px" width="80px"/>');

	
	    $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "Login"
            },
            success : function(responsejson) {
               
    $('#nameAndSurname').text(responsejson);
    
    var parameters = location.search.substring(1).split("&");//
    var temp = parameters[0].split("=");
    l = unescape(temp[1]);
   
    
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "TrainingPlan",
				accessId : l
            },
            success : function(responseJson) {
              // data = responseJson;
		 $('#loader_handle').css('display','none');	   
			   
          var tplan=JSON.parse(responseJson);

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
					else if(tplan[i].EmployeeTrainingInfoList[k].QualificationsList[z].QualificationStatus=='Complete')
					{completed++;}
					else if(tplan[i].EmployeeTrainingInfoList[k].QualificationsList[z].QualificationStatus=='Not-Trained')
					{nottrained++;}
					else
					{notdefined++;}
	}// loop qualifications

	}//loop employee names
$('.testing').css('visibility','hidden');
displaygraph(intraining,completed,nottrained,notdefined);

 
		}// outer for loop
	
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX stats  XXXXXXXXXXXXXXXXXXXXXX//


	
}//end main training function
//XXXXXXXXXXXXXXXXXXXXXXXXXXXX END MAIN TRAINING PLAN   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//


   
       
            
    });
   
       
            }
    });
		
                }	
		
	
	


//XXXXXXXXXXXXXXXXXXXXXXXXXXXX Projects start method XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//

function projects()
{
	
 $('#loader_handle').html("<span>Retrieving Data...</span>"+'<img src="img/ajax-loader.gif" style="margin-top:-28px" width="80px"/>');
	
	    $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "Login"
            },
            success : function(responsejson) {
               
    $('#nameAndSurname').text(responsejson);
    
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "BookOfWork"
            },
            success : function(responseJson) {
              
             $('#loader_handle').css("display","none");
			 	var pplan=JSON.parse(responseJson);
	$('.numberofprojects').text("("+pplan.length+")");
	for(i=0;i<pplan.length;i++)
	{
		if(document.getElementById("search").value=='')
		{
	
	$('.project_box').clone().insertBefore('div.project_box').attr('class',i).css({'margin-top':'2px','height':'65px','display':'block','border':'1px solid #ccc','background-color':'white'});
	$('.'+i).find(".projectname").text(pplan[i].ProjectName).css({'color':'#333','font-size':'20px'});
	$('.'+i).find(".cnotify").text(pplan[i].Capacity);
	$('.'+i).find(".snotify").text(pplan[i].ProjectPhases);
	$('.'+i).find(".notify").text(pplan[i].Status);
	$('.'+i).find(".enddate").text(pplan[i].EndDate);
	$('.'+i).css('display','block');
	$('.'+i).find("#clickme").attr('value',pplan[i].ProjectID);
	
		}//end if
		
		else {
							if(pplan[i].ProjectName.toLowerCase().startsWith(document.getElementById("search").value.toLowerCase())===true)
						{
							$('.'+i).css('display','block');
                                                        $("#Noresult").css('display','none');
                                                      
							}
							  else
							    {
                                                              //  $("#Noresult").css('display','block');  
                                                              //$("#Noresult").text("No results for "+'"'+document.getElementById("search").value+'"');
									$('.'+i).css('display','none');
									}
						}
	
	}
	$('.project_box').remove();
}// end main function
//XXXXXXXXXXXXXXXXXXXXXXXXXXXX Projects end method XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/

//********project id injection

//function g(cc){

	
	
//}

   
       
            
    });
   
       
            }
    });
	
        }




function project(proJName){
	
 $('#loader_handle').css("display","block");
	
	    $.ajax({             
            url : 'MainControllerServlet',
            data : { 
                check : "Login"
            },
            success : function(responsejson) {
              
    $('#nameAndSurname').text(responsejson);
   
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "HeatMap"
				
            },
            success : function(responseJson) {
              
	 $('#loader_handle').css("display","none");  		  
             var hmap=JSON.parse(responseJson);
			  
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
		$('.levl').append('<td style="background-color:white"></td>');
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

			 

   
       
            
    });
   
       
            }
    });
	
        }
	
	
	
	
	
	
function allLevl(){
	
	
	    $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "Login"
            },
            success : function(responsejson) {
               
    $('#nameAndSurname').text(responsejson);
    
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "HeatMap",
				accessId : ""
            },
            success : function(responseJson) {
              
             
			var hmap=JSON.parse(responseJson);
			 
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
	

       
            
    });
   
       
            }
    });
    }
	
	
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXX Heatmap start method XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/

window.onload = function()
{
	
 $('#loader_handle').html("<span>Retrieving Data...</span>"+'<img src="img/ajax-loader.gif" style="margin-top:-28px" width="80px"/>');
    $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "Login"
            },
            success : function(responsejson) {
               
    $('#nameAndSurname').text(responsejson);
    
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "HeatMap",
				accessId : ""
            },
            success : function(responseJson) {
                        
var hmap=JSON.parse(responseJson);


	var functionarray=[];
	var uniqueNames=[];
	
    //tabs----------
	
	var tabs = $( "#tabs" );
var ul = tabs.find( "ul.tabs_1" );

   $('#loader_handle').css("display","none");   
   
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
		$('.lev').append('<td style="background-color:white"></td>');
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
				 
                                       /////
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

				$(".heatmap_table").find("tr").eq(numberofrows).find("td").eq(loop).css("background-color",'#187616');	
				
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


				$(".heatmap_table").find("tr").eq(numberofrows).find("td").eq(loop).css("background-color",'#187616');	
				
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
	$('#alltap').click();
       
	//GetCellValues();	

}//end main function




//XXXXXXXXXXXXXXXXXXXXXXXXXXXX End method XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/

   
       
            
    });
   
       
            }
    });
	
        }	



	
	
	
	
	
	
	
//---------pass value from one page to another -----------------//
  


   
        function processForm()
  {
	  $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "Login"
            },
            success : function(responsejson) {
               
    $('#nameAndSurname').text(responsejson);
    
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "ProjectProfileView"
            },
            success : function(responseJson) {
              
             
var proj=JSON.parse(responseJson);
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
		 
	  if( proj.projectId === l )
	  {
	
	 $('#projectName').text(proj.ProjectName);
	  $('#actualAmount').text("R "+proj.ActualProjectCost);
	  $('#plannedAmount').text("R "+proj.ProjectPlanedCost);
	  $('#capacity').text(proj.Capacity);
	  $('#proj_status').text(proj.Status);
	  $('#pjnames').text(proj.ProjectManager);
	  drawbar(proj.StartDate,proj.EndDate); //method from pBar.js
	  //alert(proj.ProjectTeamList.length);
	  for(k=0;k<proj.ProjectTeamList.length;k++)
	  {
		 
		  $('.personX').clone().insertBefore('div#TeamList').attr
('class',k).css('background-color','#003366');
		  $('.'+k).find('.name').text(proj.ProjectTeamList
[k].NameAndSurname);
		  $('.'+k).find('#PlayerRole').text(proj.ProjectTeamList
[k].JobTitle);
		   
		 }//end member display
		  
		  $('.personX').remove();
			}// end if statement
		 
		// }// 
   
       
            }
    });
   
       
            }
    });
	
  }
           
	  
	

////XXXXXXXXXXXXXXXXXXXXXXXXXXXX START HIRING   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//

function hiringp(){
 $('#loader_handle').html("<span>Retrieving Data...</span>"+'<img src="img/ajax-loader.gif" style="margin-top:-28px" width="80px"/>');
	
	
	    $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "Login"
            },
            success : function(responsejson) {
               
    $('#nameAndSurname').text(responsejson);
    
     var parameters = location.search.substring(1).split("&");//
    var temp = parameters[0].split("=");
    l = unescape(temp[1]);
    
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "HiringPlan",
		accessId : l
            },
            success : function(responseJson) {
               var data = JSON.parse(responseJson);
                $('#loader_handle').html('');
                $('#loader_handle').css('display','none');
	for(i=0;i<data.length;i++){
		
$(".hire_table").append("<tr><td>"+data[i].RoleName+"</td><td>"+data[i].Level+"</td><td>"+data[i].ProjectName+"</td><td>"+data[i].Expirience+"</td><td>"+data[i].EmploymentType+"</td><td>"+data[i].NumberOfHiring+"</td><td>"+data[i].NumberOfHired+"</td><td>"+data[i].NumberOfRejected+"</td></tr>");
	

	}//end role display
	
	
}//end maun function


   
       
            
    });
   
       
            }
    });
	
	
        }
	
	
function printData()
{
   var divToPrint=document.getElementById("hire_table");
   newWin= window.open("");
   newWin.document.write(divToPrint.outerHTML);
   newWin.print();
   newWin.close();
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXX CONNECT CAPACITY PLAN   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//




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

	
	    $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "Login"
            },
            success : function(responsejson) {
               
    $('#nameAndSurname').text(responsejson);
    
    var parameters = location.search.substring(1).split("&");
    var temp = parameters[0].split("=");
    l = unescape(temp[1]);
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "Successors",
				accessId : l
            },
            success : function(responseJson) {
               
             
	var sdata=JSON.parse(responseJson);
    var parameters = location.search.substring(1).split("&");
    var temp = parameters[0].split("=");
    l = unescape(temp[1]);
	$('.current_role').text(sdata.JobTitle);
	$('.experience').text(sdata.ExpirienceAndQualification);
	$('#prede_name').text(sdata.PredeccessorNameAndSurname);
	$('#note_placed').text(sdata.NoticeDate);
	for(i=0;i<sdata.SuccessorsList.length;i++)
	{
		$('.wrap_succ_box').clone().insertAfter('div.wrap_succ_box').attr('class',i);
		$('.'+i).find("#success_description").text(sdata.SuccessorsList[i].NameAndQualification);
		$('.'+i).find(".success_status").text(sdata.SuccessorsList[i].JobTitleAndExpirience);
		$('.'+i).find(".match").text(sdata.SuccessorsList[i].MatchPercentage);
		
		}
}
	
//XXXXXXXXXXXXXXXXXXXXXXXXXXXX End successor XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//
   

   
       
            
    });
   
       
            }
    });
	
        }
	


//XXXXXXXXXXXXXXXXXXXXXXXXXXXX capacity landing start XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//

function capacitylanding()
{
	
	
	
	
	
        }
//XXXXXXXXXXXXXXXXXXXXXXXXXXXX capacity landing end XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//




//XXXXXXXXXXXXXXXXXXXXXXXXXXXX CONNECT CAPACITY PLAN   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//

//
function capacityplan(){

var proj_array=[];
var uniqueProj=[];



 $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "Login"
            },
            success : function(responsejson) {
               
    $('#nameAndSurname').text(responsejson);
    
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "MainCapacity"
				
                                
            },
            success : function(responseJson) {
               			 
              var capdata = JSON.parse(responseJson);

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

   
       
            
    });
   
       
            }
    });


}




	
    function capprojId(id){
$.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "MainCapacity"
				
            },
            success : function(responseJson) {
              
var capdata = JSON.parse(responseJson);
	$('#proj_name').text('');
	 $('#proj_name').append($('label#'+id).text());
	 $(".cap_data").remove();
	for(i=0;i<capdata.length;i++){
  for(var x = 0; x< capdata[i].capacityMain.length; x++){ 
       if(capdata[i].capacityMain[x].Proj_id == id)
  $(".table-style-three").append("<tr class='cap_data'><td>"+capdata[i].capacityMain[x].Phases+"</td><td>"+capdata[i].capacityMain[x].StartDate+"</td><td>"+capdata[i].capacityMain[x].EndDate+"</td><td>"+capdata[i].capacityMain[x].EstimatedManDays+"</td><td>"+capdata[i].capacityMain[x].ActualManDays+"</td><td>"+capdata[i].capacityMain[x].NumberOfEmployees+"</td></tr>");
  
    

   }// close for loop
	}
	}//end role display
	
	          
    });
	
	}   
        
        
   
        function projectsline()
{
   
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "Login"
            },
            success : function(responsejson) {
               
    $('#nameAndSurname').text(responsejson);
    
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "ProjectChooser"
            },
            success : function(responseJson) {
             
var pplan=JSON.parse(responseJson);
	
           var parameters = location.search.substring(1).split("&");//
    var temp = parameters[0].split("=");
    l = unescape(temp[1]);

	$('.numberofprojects').text(pplan.length);
	xxx
	for(i=0;i<pplan.length;i++)
	{
	
	$('.projects_box').clone().insertBefore('div.projects_mapping').attr('class',i).css({'margin-top':'5px','background-color':'white','width':'200px','height':'80px','display':     'inline-block','margin-right':'10px','background-color':'#C6362F','cursor':'pointer'}).attr('Book',pplan[i].ProjectName);
	$('.'+i).find("#projectid").attr('value',pplan[i].ProjectID);
	$('.'+i).find(".pp").attr('value',pplan[i].ProjectName);

		
	}
	$('.projects_mapping').css('visibility','hidden');
   
       
            }
    });
   
       
            }
    });
    
	
	
}// end main function
function populatedataonprofile()
{
 $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "Login"
            },
            success : function(responsejson) {
               
    $('#nameAndSurname').text(responsejson);
    var parameters = location.search.substring(1).split("&");
    var temp = parameters[0].split("=");
    l = unescape(temp[1]);
    
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "EmployeeProfile",
                accessId:l
            },
            success : function(responseJson) {
               
             

   var infodisplay=JSON.parse(responseJson);
	
	
	if(infodisplay.employeeID===l){
	$('#names').attr('value',infodisplay.Name);
	$('#lnames').attr('value',infodisplay.Surname);
	$('#r_name').attr('value',infodisplay.position);
	$('#sta_act').attr('value',"Status:Active");
	$('#id_num').attr('value',infodisplay.IdNumber);
	$('#citizen').attr('value',infodisplay.Citizenship);
	$('#ms').attr('value',infodisplay.MaritalStatus);
	$('#email').attr('value',infodisplay.EmailAddress);
	$('#phonenumber').attr('value',infodisplay.CellphoneNumber);
	$('#postaladdress').attr('value',infodisplay.PostalAddress);
	$('#physicaladdress').attr('value',infodisplay.PhyisicalAddress);
	$('#areacode').attr('value',infodisplay.AreaCode);
	$('#qualifications').attr('value',infodisplay.AreaCode);
	$('#institution').attr('value',infodisplay.AreaCode);
	$('#yearobtained').attr('value',infodisplay.AreaCode);
	$('#companyname').attr('value',infodisplay.AreaCode);
	$('#department').attr('value',infodisplay.AreaCode);
	$('#contracttype').attr('value',infodisplay.AreaCode);
	$('#relevantexperience').attr('value',infodisplay.revelantExpirience);
	$('#generalexperience').attr('value',infodisplay.GeneralExpirience);
	$('#level').attr('value',infodisplay.Level);
	$('#salaryrange').attr('value',infodisplay.SalaryRange);
	$('#startdate').attr('value',infodisplay.StartDate);
	$('#enddate').attr('value',infodisplay.StartDate);
	$('#projectname').attr('value',infodisplay.ProjectName);
	$('#projectrole').attr('value',infodisplay.ProjectName);
	$('#teamname').attr('value',infodisplay.ProjectName);
	$('#supervisorname').attr('value',infodisplay.ProjectName);
	}
	//remove other div
	$('#proj_fields').remove();
    $('#com').remove();	
	$('#edu').remove();	
       
            }
    });
   
       
            }
    });
	

	}// end main function

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXX End data Display On Profile XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 

function listofprofile()
{
   $('#loader_handle').html("<span>Loading profiles...</span>"+'<img src="img/ajax-loader.gif" style="margin-top:-28px" width="80px"/>');
   
   
 
	    $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "Login"
            },
            success : function(responsejson) {
               
    $('#nameAndSurname').text(responsejson);
   
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "EmployeeList"
            },
            success : function(responseJson) {
               prodata = JSON.parse(responseJson);
			   //sort list//	
	var selected = document.getElementById('filtering').value;
		if(selected=='ascending')// sort by notice
	{
	function sortByKey(array, key) {
    return array.sort(function(a, b) {
        var x = a[key]; var y = b[key];
        return ((x < y) ? -1 : ((x > y) ? 1 : 0));
    });
}

prodata = sortByKey(prodata, 'Name');


	}
	else if(selected=='descending')//sort by position
	{
		
	function sortByKey(array, key) {
    return array.sort(function(a, b) {
        var x = a[key]; var y = b[key];
       return ((x < y) ? -1 : ((x > y) ? 1 : 0));
    });
}

prodata = sortByKey(prodata, 'Name');
prodata.reverse();
	}
	
//end sort list//
       $("#Noresult").html('');        
$('#allpro').text("("+prodata.length+")");
	 $('#loader_handle').css("display","none");
	for(i=0;i<prodata.length;i++)
	{
		if(document.getElementById("search").value=='')
		{
		$('.profile_box').clone().insertBefore('div.profile_box').attr('class',i).css({'background-color':'white','-moz-animation':'fadein 2s','margin-bottom':'3px','height':'98%'});
		$('.'+i).find('#foo').attr('value',prodata[i].EmployeeID);
		$('.'+i).find('#name').text(prodata[i].Name+'   '+prodata[i].Surname+" -");
		$('.'+i).find('#roletype').text(prodata[i].Role);
               
		$('.'+i).find('.employee_descript').text(prodata[i].Qualification);
		$('.'+i).css('display','block');
                  //$("#Noresult").css('display','none');  
		}//end if empty
					else
					{
                                             
						if(prodata[i].Name.toLowerCase().startsWith(document.getElementById("search").value.toLowerCase())===true)
						{
							$('.'+i).css('display','block');
                                                        //$("#Noresult").css('display','none');
                                                      
							}
							  else
							    {
                                                               // $("#Noresult").css('display','block');  
                                                              //$("#Noresult").text("No results for "+'"'+document.getElementById("search").value+'"');
									$('.'+i).css('display','none');
									}
						}
				
		}
		{
			$('.'+i).remove();
			}
		$('.profile_box').remove();
   
       
            }
    });
   
       
            }
    });
	}
       


		//project combo listing


function list_proj(){
   // var pdata = JSON.parse(projectss);
var hdata = JSON.parse(NewHeatMap);
    
  $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "Login"
            },
            success : function(responsejson) {
               
    $('#nameAndSurname').text(responsejson);
   
     $.ajax({
            url : 'MainControllerServlet',
            data : { 
                check : "ProjectChooser"
            },
            success : function(responseJson) {
               pdata = JSON.parse(responseJson);   

//alert(pdata.length);
for(var r =0; r<pdata.length;r++){
    $("#pro_list").append('<option value="Date" onClick="FilterTeamsByProj(this.id)" id='+pdata[r].ProjectID+'>'+pdata[r].ProjectName+'</option>');
    
}


var rol_array=[];
var uniqueNames=[];


for(a=0;a<hdata.length;a++)
	{
		
	for(i=0;i<hdata[a].mainHeatMap.length;i++)
	{

			//$('.heatmap_table').append('<tr class="lev"><td>'+hmap[a].mainHeatMap[i].Level+'</td></tr>');
					
		for(k=0;k<hdata[a].mainHeatMap[i].RolesCol.length;k++)
		{
			rol_array.push(hdata[a].mainHeatMap[i].RolesCol[k].Phase);

			}//end inner forloop

		}//end second forloop

	}// end main for loop


	// create first row of the heatmap
	var checknodublicate=0;    // hide 1st col of all levels...to unhide change the value to 0.
	while(checknodublicate!=rol_array.length)
	{
	$.each(rol_array, function(i, el){
    if($.inArray(el, uniqueNames) === -1) uniqueNames.push(el);
});
	checknodublicate++;
	}
	checknodublicate=0; //also change to 0 to unhide all col's in all levels..
	
	while(checknodublicate!=uniqueNames.length)
	{
		$('#role_list').append('<option value="roles"  >'+uniqueNames[checknodublicate]+'</option>');
		
		checknodublicate++;
		}
          
            }
        });
        
            }
        });
            
            
}
    //filter teams base on the clicked project
function FilterTeamsByProj(id){
  var f = $("#hdi").attr("value",id);
   
   
     $("#teams").text("Loading Teams.");
     $.ajax({
            url : 'TeamServlet',
            data : { 
                par : id
                
            },
            success : function(responseJson) {
            var   teamlist = JSON.parse(responseJson);
             var  i = teamlist.length-1;
           
             for(var x =0 ; x < teamlist.length-1;x++){
              $("#teams").append("<option value='sp'>"+teamlist[x]+"</option>");
          
             }

            }
        });
            
       
	}
	
	
	

	
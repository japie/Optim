// JavaScript Document


(function ($) {
			    $.fn.animateProgress = function (progress, callback) {
			        return this.each(function () {
			            $(this).animate({
			                width: 100 - progress + '%',
			                left: progress + '%'
			            }, {
			                duration: 1000,
			                easing: 'swing',
			                step: function (progress) {
			                    var labelEl = $('.ui-label', this),
			                        valueEl = $('.value', labelEl);
			                },
			                complete: function (scope, i, elem) {
			                    if (callback) {
			                        callback.call(this, i, elem);
			                    };
			                }
			            });
			        });
			    };
			})(jQuery);

			var workingDate = new Date();
			var monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];


			$(document).ready(function () {
			    $("#progressBarDate").bind("change", function () {
			        workingDate = $("#progressBarDate").val();
			        drawbar(null,null);
			    });

			    $(".datePicker").datepicker({
			        dayNamesMin: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
			        showAnim: "slideDown"
			    });

			    drawbar(null,null);

			});

			function drawbar(startD,stopD) {
			    $("#progressBarDiv").hide();
			    var currentDate = new Date(workingDate);
			    var startDate;
			    var stopDate;
			    var titleBar;

			    // Hide progress bar between quaters
			    if ((currentDate.getMonth() + 1 === 3 || currentDate.getMonth() + 1 === 6 || currentDate.getMonth() + 1 === 9 || currentDate.getMonth() + 1 === 12) && currentDate.getDate() > 15) {
			        $("#progressBarDiv").hide();
			    } else {
			        if ((
			        currentDate.getMonth() + 1 === 2 || currentDate.getMonth() + 1 === 3 || currentDate.getMonth() + 1 === 5 || currentDate.getMonth() + 1 === 6 || currentDate.getMonth() + 1 === 8 || currentDate.getMonth() + 1 === 9 || currentDate.getMonth() + 1 === 11 || currentDate.getMonth() + 1 === 12)) {
			            $("#progressBarDiv").show();
			        }
			    }

			
			   
			        startDate = new Date(startD);
			        stopDate = new Date(stopD);
			       
			    
      
    var oneDay = 24 * 60 * 60 * 1000;

        if(stopDate.getTime()< currentDate.getTime()){
			      
			   
				  $('#progressDay').html("Estimated duration was met");
		$("#progressStartDate").html("Start("+monthNames[startDate.getMonth()] + " " + startDate.getDate() + ", " + startDate.getFullYear()+")");
			    $("#progressStopDate").html("End("+monthNames[stopDate.getMonth()] + " " + stopDate.getDate() + ", " + stopDate.getFullYear()+")");
				  
			}else if( startDate.getTime()> currentDate.getTime()){
				var estimatedDays=  Math.abs((stopDate.getTime() - startDate.getTime()) / oneDay);
				
				  $('#progress_bar .ui-progress').css('width', '100%');
				  $('#progressDay').html(0 + " Days Remaining");
				   titleBar = "Duration("+ estimatedDays +" Estimated days)";
				  $("#progressTitle").html(titleBar);
				$("#progressStartDate").html("Start("+monthNames[startDate.getMonth()] + " " + startDate.getDate() + ", " + startDate.getFullYear()+")");
			    $("#progressStopDate").html("End("+monthNames[stopDate.getMonth()] + " " + stopDate.getDate() + ", " + stopDate.getFullYear()+")");
				}else{
			  
				var estimatedDays=  Math.abs((stopDate.getTime() - startDate.getTime()) / oneDay);
			    var totalDays = Math.abs((stopDate.getTime() - startDate.getTime()) / oneDay);
			    var daysLeft = Math.floor(Math.abs((stopDate.getTime() - currentDate.getTime()) / oneDay)) + 1;
			    var progressPercentage = 100 - Math.floor((daysLeft / totalDays) * 100);
				 titleBar = "Duration("+ estimatedDays +" Estimated days)";
			    $('#progress_bar .ui-progressColor').css('width', '100%');
			    $('#progress_bar .ui-progress').css('width', '100%');
				
			    if (daysLeft > 1) {
			        $('#progressDay').html(daysLeft + " Days Remaining");

			    } else {
			        $('#progressDay').html(daysLeft + " Day Remaining");

			    }
				 
		 $("#progressStartDate").html("Start("+monthNames[startDate.getMonth()] + " " + startDate.getDate() + ", " + startDate.getFullYear()+")");
			    $("#progressStopDate").html("End("+monthNames[stopDate.getMonth()] + " " + stopDate.getDate() + ", " + stopDate.getFullYear()+")");
			    $("#progressTitle").html(titleBar);

			    $('#progress_bar .ui-progress').animateProgress(progressPercentage);

			    }
			}
var app=angular.module('customer',[]);
console.log('loading... Subscribe');
app.controller('customerController', function ($scope, $http) {
	
	$scope.gender = ['m','w'];
	
	$scope.customerList = [];   //variable to store the customer list
	
	$scope.viewCust = {
			id:'',
			name:{first:'',last:''},
			birthday : '',
			gender: '',
			lastContact : '',
			customerLifetimeValue  : ''
		};
	
	
	//code for plus sign
	
	$scope.addNew = function(con)
	{
		$scope.viewCust = {
				id:'',
				name:{first:'',last:''},
				birthday : '',
				gender: '',
				lastContact : '',
				customerLifetimeValue  : ''
			};
		if(con!=2)
			{
		$('#editModal').modal('show');
			}
	}
	
	//code for plus sign ends here
	
	
	//code to add the customer details
	
	$scope.addCustomer = function()
	{
		if($scope.viewCust.name.first.length != 0 && $scope.viewCust.name.last.length != 0 && $scope.viewCust.birthday && $scope.viewCust.gender.length!= 0 && $scope.viewCust.lastContact && $scope.viewCust.customerLifetimeValue.length != 0 )   //code to verify all the data is filled for adding the customer
		{
			if($scope.viewCust.id.length == 0)   //code for insert
				{
		$http.post("/webTrekk/view/addCustomer?cd="+ (new Date()).getTime(),$scope.viewCust).success(function(data) {
			$('#editModal').modal('hide');
			alert("Customer Data saved successfully");
			$scope.getCustomer();
		}).error(function(data) {

			alert("Something went wrong while adding the customer");
			$('#editModal').modal('hide');
			
			});
				}
			
			
			else  //code for update 
				{
				$http.post("/webTrekk/view/updateCustomer?cd="+ (new Date()).getTime(),$scope.viewCust).success(function(data) {
					$('#editModal').modal('hide');
					alert("Customer Data updated successfully");
					$scope.getCustomer();
				}).error(function(data) {

					alert("Something went wrong while updating the customer");
					$('#editModal').modal('hide');
					
					});
				}
		}
		
		else   //will through error if there is some fields missing
			{
			alert("Please insert all the data");
			return;
			}
	};
	
	//code to add the customer details ends here
	
	
	
	//code for getting the list of customers
	
	
	$scope.getCustomer = function()
	{
			$http.get("/webTrekk/view/getCustomer?cd="+ (new Date()).getTime()).success(function(data) {
				
				$scope.customerList=angular.copy(data);   
				for(var i=0;i<$scope.customerList.length;i++)
					{
					$scope.customerList[i].birthday = new Date($scope.customerList[i].birthday);
					$scope.customerList[i].lastcontact =  new Date($scope.customerList[i].lastcontact);
					}
			}).error(function(data) {
				alert(data);
			alert("Something went wrong while getting list of customer");
			
			});
	};
	$scope.getCustomer();
	
	//code for getting the list of customers ends here
	
	//code for view functionality
	
	$scope.editCustomer = function(index)
	{
		$scope.viewCust.id = $scope.customerList[index].id;
		$scope.viewCust.birthday = $scope.customerList[index].birthday;
		$scope.viewCust.gender = $scope.customerList[index].gender;
		$scope.viewCust.lastContact = $scope.customerList[index].lastcontact;
		$scope.viewCust.customerLifetimeValue = $scope.customerList[index].customerlifetimevalue;
		$scope.viewCust.name.first = $scope.customerList[index].first;
		$scope.viewCust.name.last = $scope.customerList[index].last;
		$('#editModal').modal('show');
	};
	
	//code for view functionality ends here
	
	//code to remove the customer
	
	$scope.removeCustomer = function()
	{
		$http.get("/webTrekk/view/removeCustomer/"+$scope.deleteIndex+"?cd="+(new Date()).getTime()).success(function(data) {
			$('#deleteModal').modal('hide');
			alert("Customer data deleted successfully");
			$scope.getCustomer();
		}).error(function(data) {
		
		alert("Something went wrong while deleting the customer data");
			
		});
	};
	
	//code to remove the customer ends here
	
	//code for open confirmation pop upp
	
	$scope.deleteConfirm = function(id)
	{
		$scope.deleteIndex = id;
		$('#deleteModal').modal('show');
	}
	
	//code for open confirmation pop up ends here
});


//code for only entering the number
 
function isNumberKey(evt) {

var charCode = (evt.which) ? evt.which : evt.keyCode;

if (charCode > 31 && (charCode < 48 || charCode > 57)) {
return false;
} else {
return true;
}
} // isNumberKey

//code for only entering the number ends here


//code for validating the decimal number

function validateDecimal(obj, evt) {

	value = obj.value;
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57) && charCode != 46) { //checking for allowing the number and decimals
		return false;
	}
	value = value.toString();
	var number = value.split('.');
	var postdec = number[1];
	if (undefined === postdec && value.length > 4 && charCode != 46) { //checking the length before decimal
		return false;
	}
	var index = value.indexOf('.'); 
	if (index != -1 && charCode == 46) {   //checking if only . is added
		return false;
	}
	if (postdec.length > 1) {// allowing 2 number after decimals 
		return false;
	}
	}

 
//code for validating the decimal numbers ends here



BookMyShow

REST API

Post =-> Give the information to database
Put =-> Update the information 
Get =-> Get the information to database
Delete =-> Delete the Information 

Admin ==> RequestMapping(“Admin”) ==—> 16
	->Login ==> GET (/Login) S
	-> Update Password ==> PUT (/UpdatePassword/{userName}) S
	->Add Movie Item ==> POST (/AddItem) S 
	->Display Movie Item ==> GET (/DisplayMovie) S
	->Updata Movie ==> PUT (/UpdateMovie/{movieId}) S
	->Delete Movie ==> DELETE (/DeleteMovie/{movieId}) S
	->Show User Information ==> GET (/UserInformation) S
	->Delete Feedback ==> DELETE (/deleteFeedback/{id}) S

User ==> RequestMapping(“/User”)
	-> Login ==>GET (/Login) S
	-> SingUp ==> POST (/Singup) S
	-> Update Password ==> PUT (/UpdatePassword/{userName}) S
	-> Display Movie Shows ==> GET (/DisplayMovies) S
	-> Movie Booking ==> POST (/MovieBooking) S
	-> Display History ==> GET (/DisplayHistory/{userName}) S
	-> Post Feedback ==> POST (/Feedback) S

Feedback Reviews — (Show Without Login)
 	-> Display All FeedBack About Movie ==> GET (/DisplayFeedback) S


DATABASE —> BookMyShow

Admin —>
		-> UserName
		-> Password
User —>
		-> UserName
		-> Password
		-> NameOfUser
		-> MobileNumber
		-> MailId
		-> DateOfBirth
		-> Address
Movie —>
		-> MovieId
		-> MovieName
		-> MovieRating
		-> Description
		-> MovieRealiceData
		-> MovieDuration
		-> MaxSeat
		-> MoviePosterUrl
		-> MoviePrice
Booking —>
		-> Id
		-> UserName
		->MovieId
		-> Price
		-> Quantity
Feedback —>
		-> Id
		-> MovieId
		-> UserName
		-> MovieName
		-> Feedback

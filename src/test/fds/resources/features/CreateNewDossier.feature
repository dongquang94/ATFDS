@Create
Feature: CreateNewDossier
  Create New Dossier

	Background: User navigates to page
		Given I am on URL "http://103.21.148.29/"
    
  @CreateSuccess
  Scenario: Title of your scenario
  	#login creater
  	When I fill in username "nthnga@cmc.com.vn" and password "abc@123"
    And I click on the "Đăng nhập" button
    #create
    And I click on the "Quản lý hồ sơ" button
    And I click on the "Tạo hồ sơ mới" button
    And I click on the "Chọn" button
    #Cấp giấy phép đưa thí sinh đi tham dự cuộc thi người đẹp, người mẫu quốc tế
    And I click on the "Cấp giấy phép đưa thí sinh đi tham dự cuộc thi người đẹp, người mẫu quốc tế" button
		#fill data to form
		And I fill in "Full Name" "Mrs Bui Hong Tuan"
		And I click on the "Ghi lại" button
		#Then I should see success message "Yêu cầu được thực hiện thành công!"
		#file upload
		And I click file upload "TP2"
		#Then I should see success message "Yêu cầu được thực hiện thành công"
		And I click file upload "TP3"
		#Then I should see success message "Yêu cầu được thực hiện thành công"
		And I click file upload "TP4"
		#Then I should see success message "Yêu cầu được thực hiện thành công"
		And I click file upload "TP5"
		#Then I should see success message "Yêu cầu được thực hiện thành công"
		And I click file upload "TP6"
		#Then I should see success message "Yêu cầu được thực hiện thành công"
		#submit
		And I click on the "Lưu" button
		#Then I should see button "Nộp hồ sơ"
		And I click on the "Nộp hồ sơ" button
		#Then I should see confirm dialog
		And I click on the "Nộp hồ sơ" in confirm dialog
		#Then I should see success message "Nộp hồ sơ thành công" //*[@id="completedDossierForm"]/div[2]/div[1]/h3
		#logout
		And I click on the label "Tên công ty/tổ chức"
		And I choose " Đăng xuất" in dropdown menu
		#login manager
		And I fill in username "user15@cmc.com.vn" and password "abc@123"
    And I click on the "Đăng nhập" button
		#search dossier
		And I fill dossier id to search box
		#manage
		And I choose dossier in the top
		And I click on the "Thụ lý hồ sơ" button
		And I click on the "Hồ sơ hợp lệ" button
		#dossier synchronous
		And I fill in "Comment" "đồng ý"
		And I click file upload ""
		And I click on the "Xác nhận" button
		
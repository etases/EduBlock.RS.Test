# AccountScenario
## createAccount
* **assertTrue** expected: `true`, actual: `true`
* **assertNotNull** expected: `not null`, actual: `[AccountWithProfileOutput(account=AccountOutput(id=1, username=TienH, role=ADMIN, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=1, firstName=Tien, lastName=Huynh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=2, username=TuL, role=STAFF, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=2, firstName=Tu, lastName=Le, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `4`, actual: `4`
* **assertAnyMatch** expected: `true`, actual: `true`
* **assertAnyMatch** expected: `true`, actual: `true`
* **assertAnyMatch** expected: `true`, actual: `true`
* **assertAnyMatch** expected: `true`, actual: `true`
## loginAdmin
* **assertTrue** expected: `true`, actual: `true`
* **assertNotNull** expected: `not null`, actual: `eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlZHVibG9jay1jbGllbnQiLCJzdWIiOiJlZHVibG9jayIsInJvbGUiOiJBRE1JTiIsIm5hbWUiOiJUaWVuSCIsImlzcyI6ImVkdWJsb2NrLnJzIiwiaWQiOjF9.ZNVC-zgW4OQR8l-GONSCuJd_OS97MPcNOdSoIBqdV_Y`
* **assertFalse** expected: `false`, actual: `false`
## loginStaff
* **assertTrue** expected: `true`, actual: `true`
* **assertNotNull** expected: `not null`, actual: `eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlZHVibG9jay1jbGllbnQiLCJzdWIiOiJlZHVibG9jayIsInJvbGUiOiJTVEFGRiIsIm5hbWUiOiJUdUwiLCJpc3MiOiJlZHVibG9jay5ycyIsImlkIjoyfQ.PlXURigec5QhoUhE_5uchnS9j7ZGY3BygE5-L0TFyRo`
* **assertFalse** expected: `false`, actual: `false`
## loginTeacher
* **assertTrue** expected: `true`, actual: `true`
* **assertNotNull** expected: `not null`, actual: `eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlZHVibG9jay1jbGllbnQiLCJzdWIiOiJlZHVibG9jayIsInJvbGUiOiJURUFDSEVSIiwibmFtZSI6IkRhUSIsImlzcyI6ImVkdWJsb2NrLnJzIiwiaWQiOjN9.8zGcKiZPhET1VaPry69kGUwpFYZvT4pkhoJ5IhKIk-s`
* **assertFalse** expected: `false`, actual: `false`
## loginStudent
* **assertTrue** expected: `true`, actual: `true`
* **assertNotNull** expected: `not null`, actual: `eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlZHVibG9jay1jbGllbnQiLCJzdWIiOiJlZHVibG9jayIsInJvbGUiOiJTVFVERU5UIiwibmFtZSI6IlV5Q0hBIiwiaXNzIjoiZWR1YmxvY2sucnMiLCJpZCI6NH0.GMozxy79flqZwveunVyY3PpPFeuBaq8M7VgABsbV9Mo`
* **assertFalse** expected: `false`, actual: `false`
## loginInvalid
* **assertTrue** expected: `true`, actual: `true`
## authorizeCheck
* **assertEquals** expected: `200`, actual: `200`
* **assertEquals** expected: `401`, actual: `401`
* **assertEquals** expected: `401`, actual: `401`
* **assertEquals** expected: `401`, actual: `401`
* **assertEquals** expected: `Hello Admin`, actual: `Hello Admin`
* **assertEquals** expected: `-1990`, actual: `-1990`
* **assertEquals** expected: `-1990`, actual: `-1990`
* **assertEquals** expected: `-1990`, actual: `-1990`
## getOwnAccount
* **assertTrue** expected: `true`, actual: `true`
* **assertNotNull** expected: `not null`, actual: `AccountWithProfileOutput(account=AccountOutput(id=1, username=TienH, role=ADMIN, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=1, firstName=Tien, lastName=Huynh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `TienH`, actual: `TienH`
* **assertTrue** expected: `true`, actual: `true`
* **assertNotNull** expected: `not null`, actual: `AccountWithProfileOutput(account=AccountOutput(id=2, username=TuL, role=STAFF, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=2, firstName=Tu, lastName=Le, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `TuL`, actual: `TuL`
## getAccount
* **assertTrue** expected: `true`, actual: `true`
* **assertNotNull** expected: `not null`, actual: `AccountWithProfileOutput(account=AccountOutput(id=1, username=TienH, role=ADMIN, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=1, firstName=Tien, lastName=Huynh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `TienH`, actual: `TienH`
* **assertTrue** expected: `true`, actual: `true`
* **assertNotNull** expected: `not null`, actual: `AccountWithProfileOutput(account=AccountOutput(id=2, username=TuL, role=STAFF, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=2, firstName=Tu, lastName=Le, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `TuL`, actual: `TuL`
* **assertTrue** expected: `true`, actual: `true`
* **assertEquals** expected: `1`, actual: `1`
* **assertNull** expected: `null`, actual: `null`
## getAllAccount
* **assertTrue** expected: `true`, actual: `true`
* **assertNotNull** expected: `not null`, actual: `[AccountWithProfileOutput(account=AccountOutput(id=1, username=TienH, role=ADMIN, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=1, firstName=Tien, lastName=Huynh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=2, username=TuL, role=STAFF, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=2, firstName=Tu, lastName=Le, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `4`, actual: `4`
* **assertAnyMatch** expected: `true`, actual: `true`
* **assertAnyMatch** expected: `true`, actual: `true`
* **assertAnyMatch** expected: `true`, actual: `true`
* **assertAnyMatch** expected: `true`, actual: `true`
## getPagedAllAccount
* **assertTrue** expected: `true`, actual: `true`
* **assertNotNull** expected: `not null`, actual: `[AccountWithProfileOutput(account=AccountOutput(id=1, username=TienH, role=ADMIN, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=1, firstName=Tien, lastName=Huynh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=2, username=TuL, role=STAFF, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=2, firstName=Tu, lastName=Le, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `2`, actual: `2`
* **assertAnyMatch** expected: `true`, actual: `true`
* **assertAnyMatch** expected: `true`, actual: `true`
* **assertTrue** expected: `true`, actual: `true`
* **assertNotNull** expected: `not null`, actual: `[AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `2`, actual: `2`
* **assertAnyMatch** expected: `true`, actual: `true`
* **assertAnyMatch** expected: `true`, actual: `true`
## getAccountByRole
* **assertTrue** expected: `true`, actual: `true`
* **assertTrue** expected: `true`, actual: `true`
* **assertTrue** expected: `true`, actual: `true`
* **assertTrue** expected: `true`, actual: `true`
* **assertNotNull** expected: `not null`, actual: `[AccountWithProfileOutput(account=AccountOutput(id=1, username=TienH, role=ADMIN, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=1, firstName=Tien, lastName=Huynh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertNotNull** expected: `not null`, actual: `[AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertNotNull** expected: `not null`, actual: `[AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), student=StudentOutput(id=4, ethnic=, fatherName=, fatherJob=, motherName=, motherJob=, guardianName=, guardianJob=, homeTown=), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertNotNull** expected: `not null`, actual: `[AccountWithProfileOutput(account=AccountOutput(id=2, username=TuL, role=STAFF, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=2, firstName=Tu, lastName=Le, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
* **assertEquals** expected: `1`, actual: `1`
* **assertEquals** expected: `1`, actual: `1`
* **assertEquals** expected: `1`, actual: `1`
* **assertAnyMatch** expected: `true`, actual: `true`
* **assertAnyMatch** expected: `true`, actual: `true`
* **assertAnyMatch** expected: `true`, actual: `true`
* **assertAnyMatch** expected: `true`, actual: `true`
## changePassword
* **assertEquals** expected: `200`, actual: `200`
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlZHVibG9jay1jbGllbnQiLCJzdWIiOiJlZHVibG9jayIsInJvbGUiOiJBRE1JTiIsIm5hbWUiOiJUaWVuSCIsImlzcyI6ImVkdWJsb2NrLnJzIiwiaWQiOjF9.ZNVC-zgW4OQR8l-GONSCuJd_OS97MPcNOdSoIBqdV_Y`
* **assertFalse** expected: `false`, actual: `false`
## changeSelfProfile
* **assertEquals** expected: `200`, actual: `200`
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `AccountWithProfileOutput(account=AccountOutput(id=1, username=TienH, role=ADMIN, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=1, firstName=Tien, lastName=Huynh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=test@test.com))`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `Tien`, actual: `Tien`
* **assertEquals** expected: `Huynh`, actual: `Huynh`
* **assertEquals** expected: `true`, actual: `true`
* **assertEquals** expected: ``, actual: ``
* **assertEquals** expected: `Thu Jan 01 08:00:00 ICT 1970`, actual: `Thu Jan 01 08:00:00 ICT 1970`
* **assertEquals** expected: `Ha Noi`, actual: `Ha Noi`
* **assertEquals** expected: `0123456789`, actual: `0123456789`
* **assertEquals** expected: `test@test.com`, actual: `test@test.com`
## changeProfile
* **assertEquals** expected: `200`, actual: `200`
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `Da`, actual: `Da`
* **assertEquals** expected: `Quach`, actual: `Quach`
* **assertEquals** expected: `true`, actual: `true`
* **assertEquals** expected: ``, actual: ``
* **assertEquals** expected: `Thu Jan 01 08:00:00 ICT 1970`, actual: `Thu Jan 01 08:00:00 ICT 1970`
* **assertEquals** expected: `Ha Noi`, actual: `Ha Noi`
* **assertEquals** expected: `0123456789`, actual: `0123456789`
* **assertEquals** expected: `daql@test.com`, actual: `daql@test.com`
## updateStudentProfile
* **assertEquals** expected: `200`, actual: `200`
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))`
* **assertFalse** expected: `false`, actual: `false`
* **assertNotNull** expected: `not null`, actual: `StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho)`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `Kinh`, actual: `Kinh`
* **assertEquals** expected: `Nguyen Van A`, actual: `Nguyen Van A`
* **assertEquals** expected: `Giang vien`, actual: `Giang vien`
* **assertEquals** expected: `Tran Thi B`, actual: `Tran Thi B`
* **assertEquals** expected: `Mua ban`, actual: `Mua ban`
* **assertEquals** expected: `Trang Thi C`, actual: `Trang Thi C`
* **assertEquals** expected: `Ki su`, actual: `Ki su`
* **assertEquals** expected: `Can Tho`, actual: `Can Tho`
* **assertEquals** expected: `404`, actual: `404`
# ClassroomScenario
## createClassroom
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `ClassroomOutput(id=1, name=10A2, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
* **assertEquals** expected: `10A2`, actual: `10A2`
* **assertEquals** expected: `10`, actual: `10`
* **assertEquals** expected: `2020`, actual: `2020`
* **assertEquals** expected: `3`, actual: `3`
## addStudentToClassroom
* **assertEquals** expected: `200`, actual: `200`
## addTeacherToClassroom
* **assertEquals** expected: `200`, actual: `200`
## getStudentFromClassroom
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `[AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
* **assertAnyMatch** expected: `true`, actual: `true`
## getTeacherFromClassroom
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `[TeacherWithSubjectOutput(account=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), subject=SubjectOutput(id=1, identifier=MATH, name=Toán, otherNames=[Mathematics, Math]))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
* **assertAnyMatch** expected: `true`, actual: `true`
## removeStudentFromClassroom
* **assertEquals** expected: `200`, actual: `200`
* **assertEquals** expected: `200`, actual: `200`
## removeTeacherFromClassroom
* **assertEquals** expected: `200`, actual: `200`
* **assertEquals** expected: `200`, actual: `200`
## getClassroomList
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `[ClassroomOutput(id=1, name=10A2, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
* **assertAnyMatch** expected: `true`, actual: `true`
## getClassroomListAsTeacher
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `[ClassroomOutput(id=1, name=10A2, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
* **assertAnyMatch** expected: `true`, actual: `true`
## getClassroomListAsStudent
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `[ClassroomOutput(id=1, name=10A2, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
* **assertAnyMatch** expected: `true`, actual: `true`
## getClassroomListAsHomeroom
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `[ClassroomOutput(id=1, name=10A2, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
* **assertAnyMatch** expected: `true`, actual: `true`
## getClassroomById
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `ClassroomOutput(id=1, name=10A2, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
## updateClassroom
* **assertEquals** expected: `200`, actual: `200`
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
* **assertEquals** expected: `10A1`, actual: `10A1`
* **assertEquals** expected: `10`, actual: `10`
* **assertEquals** expected: `2021`, actual: `2021`
* **assertEquals** expected: `3`, actual: `3`
# RecordScenario
## requestChange
* **assertEquals** expected: `200`, actual: `200`
* **assertEquals** expected: `200`, actual: `200`
## getPendingRecordEntries
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `[PendingRecordEntryOutput(id=1, subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=Toán, otherNames=[Mathematics, Math]), firstHalfScore=5.0, secondHalfScore=5.0, finalScore=5.0, requestDate=Fri Nov 25 13:39:41 ICT 2022, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))), PendingRecordEntryOutput(id=2, subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=Toán, otherNames=[Mathematics, Math]), firstHalfScore=10.0, secondHalfScore=10.0, finalScore=10.0, requestDate=Fri Nov 25 13:39:41 ICT 2022, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `2`, actual: `2`
* **assertAnyMatch** expected: `true`, actual: `true`
* **assertAnyMatch** expected: `true`, actual: `true`
## getPendingRecordEntriesByStudentId
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `[PendingRecordEntryOutput(id=1, subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=Toán, otherNames=[Mathematics, Math]), firstHalfScore=5.0, secondHalfScore=5.0, finalScore=5.0, requestDate=Fri Nov 25 13:39:41 ICT 2022, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))), PendingRecordEntryOutput(id=2, subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=Toán, otherNames=[Mathematics, Math]), firstHalfScore=10.0, secondHalfScore=10.0, finalScore=10.0, requestDate=Fri Nov 25 13:39:41 ICT 2022, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `2`, actual: `2`
* **assertAnyMatch** expected: `true`, actual: `true`
* **assertAnyMatch** expected: `true`, actual: `true`
## verifyRequest
* **assertEquals** expected: `200`, actual: `200`
* **assertEquals** expected: `200`, actual: `200`
## getRecordListByClassroomId
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `[RecordWithStudentOutput(classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))), entries=[RecordEntryOutput(subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=Toán, otherNames=[Mathematics, Math]), firstHalfScore=10.0, secondHalfScore=10.0, finalScore=10.0, requestDate=Fri Nov 25 13:39:41 ICT 2022, approvalDate=Fri Nov 25 13:39:41 ICT 2022, updateComplete=false, fromFabric=false, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), approver=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))], classification=ClassificationReportOutput(firstHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), secondHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), finalClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
* **assertAnyMatch** expected: `true`, actual: `true`
## getOwnRecordEntries
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `RecordOutput(classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))), entries=[RecordEntryOutput(subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=Toán, otherNames=[Mathematics, Math]), firstHalfScore=10.0, secondHalfScore=10.0, finalScore=10.0, requestDate=Fri Nov 25 13:39:41 ICT 2022, approvalDate=Fri Nov 25 13:39:41 ICT 2022, updateComplete=false, fromFabric=false, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), approver=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))], classification=ClassificationReportOutput(firstHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), secondHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), finalClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647)))`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
* **assertAnyMatch** expected: `true`, actual: `true`
## getRecordById
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `RecordOutput(classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))), entries=[RecordEntryOutput(subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=Toán, otherNames=[Mathematics, Math]), firstHalfScore=10.0, secondHalfScore=10.0, finalScore=10.0, requestDate=Fri Nov 25 13:39:41 ICT 2022, approvalDate=Fri Nov 25 13:39:41 ICT 2022, updateComplete=false, fromFabric=false, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), approver=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))], classification=ClassificationReportOutput(firstHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), secondHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), finalClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647)))`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
* **assertAnyMatch** expected: `true`, actual: `true`
## getRecordListByGradeAndYear
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `[RecordWithStudentOutput(classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))), entries=[RecordEntryOutput(subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=Toán, otherNames=[Mathematics, Math]), firstHalfScore=10.0, secondHalfScore=10.0, finalScore=10.0, requestDate=Fri Nov 25 13:39:41 ICT 2022, approvalDate=Fri Nov 25 13:39:41 ICT 2022, updateComplete=false, fromFabric=false, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), approver=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Nov 25 13:39:40 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))], classification=ClassificationReportOutput(firstHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), secondHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), finalClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Nov 25 13:39:40 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)))]`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
* **assertAnyMatch** expected: `true`, actual: `true`
# SubjectScenario
## getSubjectList
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `[SubjectOutput(id=1, identifier=MATH, name=Toán, otherNames=[Mathematics, Math]), SubjectOutput(id=2, identifier=PHYSICS, name=Vật lý, otherNames=[Physics, Phys]), SubjectOutput(id=3, identifier=CHEMISTRY, name=Hóa học, otherNames=[Chemistry, Chem]), SubjectOutput(id=4, identifier=BIOLOGY, name=Sinh học, otherNames=[Biology, Bio]), SubjectOutput(id=5, identifier=INFORMATICS, name=Tin học, otherNames=[Informatics, Info]), SubjectOutput(id=6, identifier=LITERATURE, name=Văn học, otherNames=[Literature, Lit, Văn, Ngữ văn]), SubjectOutput(id=7, identifier=HISTORY, name=Lịch sử, otherNames=[History, Hist]), SubjectOutput(id=8, identifier=GEOGRAPHY, name=Địa lý, otherNames=[Geography, Geo]), SubjectOutput(id=9, identifier=FOREIGN_LANGUAGE, name=Ngoại ngữ, otherNames=[Foreign Language, FL]), SubjectOutput(id=10, identifier=CITIZENSHIP, name=Giáo dục công dân, otherNames=[Citizenship, Cit, Đạo đức]), SubjectOutput(id=11, identifier=TECHNOLOGY, name=Công nghệ, otherNames=[Technology, Tech]), SubjectOutput(id=12, identifier=PHYSICAL, name=Thể dục, otherNames=[Physical Education, Phys Ed]), SubjectOutput(id=13, identifier=ART, name=Mỹ thuật, otherNames=[Art]), SubjectOutput(id=14, identifier=MUSIC, name=Âm nhạc, otherNames=[Music]), SubjectOutput(id=15, identifier=NATIONAL_EDUCATION, name=Giáo dục quốc phòng, otherNames=[National Education, NE, Giáo dục QP-AN, QP-AN, Quốc phòng])]`
* **assertFalse** expected: `false`, actual: `false`
* **assertFalse** expected: `false`, actual: `false`
* **assertFalse** expected: `false`, actual: `false`
## getSubjectById
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `SubjectOutput(id=1, identifier=MATH, name=Toán, otherNames=[Mathematics, Math])`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `1`, actual: `1`
* **assertEquals** expected: `404`, actual: `404`
# ClassificationScenario
## getClassificationList
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `[ClassificationOutput(identifier=GREAT, name=Giỏi, otherNames=[Great], level=1), ClassificationOutput(identifier=GOOD, name=Khá, otherNames=[Good], level=2), ClassificationOutput(identifier=FAIR, name=Trung bình, otherNames=[], level=3), ClassificationOutput(identifier=BAD, name=Yếu, otherNames=[Bad], level=4), ClassificationOutput(identifier=FAIL, name=Kém, otherNames=[Fail], level=5)]`
* **assertFalse** expected: `false`, actual: `false`
* **assertFalse** expected: `false`, actual: `false`
* **assertFalse** expected: `false`, actual: `false`
## getClassificationById
* **assertEquals** expected: `200`, actual: `200`
* **assertNotNull** expected: `not null`, actual: `ClassificationOutput(identifier=GOOD, name=Khá, otherNames=[Good], level=2)`
* **assertFalse** expected: `false`, actual: `false`
* **assertEquals** expected: `GOOD`, actual: `GOOD`
* **assertEquals** expected: `404`, actual: `404`
# Final Report
* Scenario: 5
* Test: 41
* Assert: 202

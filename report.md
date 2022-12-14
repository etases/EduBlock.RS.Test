# AccountScenario

## createAccount

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `[AccountWithProfileOutput(account=AccountOutput(id=1, username=TienH, role=ADMIN, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=1, firstName=Tien, lastName=Huynh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=2, username=TuL, role=STAFF, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=2, firstName=Tu, lastName=Le, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `4`

  Actual: `4`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## loginAdmin

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlZHVibG9jay5jbGllbnQiLCJzdWIiOiJlZHVibG9jayIsInJvbGUiOiJBRE1JTiIsIm5hbWUiOiJUaWVuSCIsImlzcyI6ImVkdWJsb2NrLmlzc3VlciIsImlkIjoxfQ.E1EpWjxNhCJh1Gp6CrFyXU1EV3szTvxarFFGjjbDG2I`

- **assertFalse**

  Expected: `false`

  Actual: `false`

## loginStaff

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlZHVibG9jay5jbGllbnQiLCJzdWIiOiJlZHVibG9jayIsInJvbGUiOiJTVEFGRiIsIm5hbWUiOiJUdUwiLCJpc3MiOiJlZHVibG9jay5pc3N1ZXIiLCJpZCI6Mn0.gxikH29UpH06CAUYqkUVZWvDGKO0ilurYnSD4uI96Dg`

- **assertFalse**

  Expected: `false`

  Actual: `false`

## loginTeacher

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlZHVibG9jay5jbGllbnQiLCJzdWIiOiJlZHVibG9jayIsInJvbGUiOiJURUFDSEVSIiwibmFtZSI6IkRhUSIsImlzcyI6ImVkdWJsb2NrLmlzc3VlciIsImlkIjozfQ.t89wGcWphH7Dy9L8sfgyV99JldXmY85rcTw4dGoth6c`

- **assertFalse**

  Expected: `false`

  Actual: `false`

## loginStudent

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlZHVibG9jay5jbGllbnQiLCJzdWIiOiJlZHVibG9jayIsInJvbGUiOiJTVFVERU5UIiwibmFtZSI6IlV5Q0hBIiwiaXNzIjoiZWR1YmxvY2suaXNzdWVyIiwiaWQiOjR9.WMniyohmBvKGisAZnjSGfd1bl8XfZNS_7ari6lcuxxU`

- **assertFalse**

  Expected: `false`

  Actual: `false`

## loginInvalid

- **assertTrue**

  Expected: `true`

  Actual: `true`

## authorizeCheck

### Admin

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertEquals**

  Expected: `Hello Admin`

  Actual: `Hello Admin`

### Staff

- **assertEquals**

  Expected: `401`

  Actual: `401`

- **assertEquals**

  Expected: `-1990`

  Actual: `-1990`

### Teacher

- **assertEquals**

  Expected: `401`

  Actual: `401`

- **assertEquals**

  Expected: `-1990`

  Actual: `-1990`

### Student

- **assertEquals**

  Expected: `401`

  Actual: `401`

- **assertEquals**

  Expected: `-1990`

  Actual: `-1990`

## getOwnAccount

### Admin

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `AccountWithProfileOutput(account=AccountOutput(id=1, username=TienH, role=ADMIN, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=1, firstName=Tien, lastName=Huynh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `TienH`

  Actual: `TienH`

### Staff

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `AccountWithProfileOutput(account=AccountOutput(id=2, username=TuL, role=STAFF, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=2, firstName=Tu, lastName=Le, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `TuL`

  Actual: `TuL`

## getAccount

### Admin

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `AccountWithProfileOutput(account=AccountOutput(id=1, username=TienH, role=ADMIN, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=1, firstName=Tien, lastName=Huynh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `TienH`

  Actual: `TienH`

### Staff

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `AccountWithProfileOutput(account=AccountOutput(id=2, username=TuL, role=STAFF, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=2, firstName=Tu, lastName=Le, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `TuL`

  Actual: `TuL`

### Teacher

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertNull**

  Expected: `null`

  Actual: `null`

## getAllAccount

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `[AccountWithProfileOutput(account=AccountOutput(id=1, username=TienH, role=ADMIN, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=1, firstName=Tien, lastName=Huynh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=2, username=TuL, role=STAFF, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=2, firstName=Tu, lastName=Le, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `4`

  Actual: `4`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## getPagedAllAccount

### Page 1

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `[AccountWithProfileOutput(account=AccountOutput(id=1, username=TienH, role=ADMIN, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=1, firstName=Tien, lastName=Huynh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=2, username=TuL, role=STAFF, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=2, firstName=Tu, lastName=Le, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `2`

  Actual: `2`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

### Page 2

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `[AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `2`

  Actual: `2`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## getAccountByRole

### Admin

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `[AccountWithProfileOutput(account=AccountOutput(id=1, username=TienH, role=ADMIN, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=1, firstName=Tien, lastName=Huynh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

### Teacher

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `[AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

### Student

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `[AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), student=StudentOutput(id=4, ethnic=, fatherName=, fatherJob=, motherName=, motherJob=, guardianName=, guardianJob=, homeTown=), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

### Staff

- **assertTrue**

  Expected: `true`

  Actual: `true`

- **assertNotNull**

  Expected: `not null`

  Actual: `[AccountWithProfileOutput(account=AccountOutput(id=2, username=TuL, role=STAFF, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=2, firstName=Tu, lastName=Le, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## changePassword

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlZHVibG9jay5jbGllbnQiLCJzdWIiOiJlZHVibG9jayIsInJvbGUiOiJBRE1JTiIsIm5hbWUiOiJUaWVuSCIsImlzcyI6ImVkdWJsb2NrLmlzc3VlciIsImlkIjoxfQ.E1EpWjxNhCJh1Gp6CrFyXU1EV3szTvxarFFGjjbDG2I`

- **assertFalse**

  Expected: `false`

  Actual: `false`

## changeSelfProfile

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `AccountWithProfileOutput(account=AccountOutput(id=1, username=TienH, role=ADMIN, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=1, firstName=Tien, lastName=Huynh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=test@test.com))`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `Tien`

  Actual: `Tien`

- **assertEquals**

  Expected: `Huynh`

  Actual: `Huynh`

- **assertEquals**

  Expected: `true`

  Actual: `true`

- **assertEquals**

  Expected: ``

  Actual: ``

- **assertEquals**

  Expected: `Thu Jan 01 08:00:00 ICT 1970`

  Actual: `Thu Jan 01 08:00:00 ICT 1970`

- **assertEquals**

  Expected: `Ha Noi`

  Actual: `Ha Noi`

- **assertEquals**

  Expected: `0123456789`

  Actual: `0123456789`

- **assertEquals**

  Expected: `test@test.com`

  Actual: `test@test.com`

## changeProfile

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `Da`

  Actual: `Da`

- **assertEquals**

  Expected: `Quach`

  Actual: `Quach`

- **assertEquals**

  Expected: `true`

  Actual: `true`

- **assertEquals**

  Expected: ``

  Actual: ``

- **assertEquals**

  Expected: `Thu Jan 01 08:00:00 ICT 1970`

  Actual: `Thu Jan 01 08:00:00 ICT 1970`

- **assertEquals**

  Expected: `Ha Noi`

  Actual: `Ha Noi`

- **assertEquals**

  Expected: `0123456789`

  Actual: `0123456789`

- **assertEquals**

  Expected: `daql@test.com`

  Actual: `daql@test.com`

## updateStudentProfile

### Valid

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertNotNull**

  Expected: `not null`

  Actual: `StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho)`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `Kinh`

  Actual: `Kinh`

- **assertEquals**

  Expected: `Nguyen Van A`

  Actual: `Nguyen Van A`

- **assertEquals**

  Expected: `Giang vien`

  Actual: `Giang vien`

- **assertEquals**

  Expected: `Tran Thi B`

  Actual: `Tran Thi B`

- **assertEquals**

  Expected: `Mua ban`

  Actual: `Mua ban`

- **assertEquals**

  Expected: `Trang Thi C`

  Actual: `Trang Thi C`

- **assertEquals**

  Expected: `Ki su`

  Actual: `Ki su`

- **assertEquals**

  Expected: `Can Tho`

  Actual: `Can Tho`

### Invalid

- **assertEquals**

  Expected: `404`

  Actual: `404`

# ClassroomScenario

## createClassroom

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `ClassroomOutput(id=1, name=10A2, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertEquals**

  Expected: `10A2`

  Actual: `10A2`

- **assertEquals**

  Expected: `10`

  Actual: `10`

- **assertEquals**

  Expected: `2020`

  Actual: `2020`

- **assertEquals**

  Expected: `3`

  Actual: `3`

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `ClassroomOutput(id=2, name=10A3, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `2`

  Actual: `2`

- **assertEquals**

  Expected: `10A3`

  Actual: `10A3`

- **assertEquals**

  Expected: `10`

  Actual: `10`

- **assertEquals**

  Expected: `2020`

  Actual: `2020`

- **assertEquals**

  Expected: `3`

  Actual: `3`

## addStudentToClassroom

### Success

- **assertEquals**

  Expected: `200`

  Actual: `200`

### Same class

- **assertEquals**

  Expected: `400`

  Actual: `400`

- **assertNotNull**

  Expected: `not null`

  Actual: `[me.hsgamer.edublock.rs.test.model.output.AccountErrorListResponse$ErrorData@76a4ebf2]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertEquals**

  Expected: `4`

  Actual: `4`

- **assertEquals**

  Expected: `2`

  Actual: `2`

### Same year

- **assertEquals**

  Expected: `400`

  Actual: `400`

- **assertNotNull**

  Expected: `not null`

  Actual: `[me.hsgamer.edublock.rs.test.model.output.AccountErrorListResponse$ErrorData@2e8c1c9b]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertEquals**

  Expected: `4`

  Actual: `4`

- **assertEquals**

  Expected: `3`

  Actual: `3`

## addTeacherToClassroom

- **assertEquals**

  Expected: `200`

  Actual: `200`

## getStudentFromClassroom

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `[AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## getTeacherFromClassroom

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `[TeacherWithSubjectOutput(account=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), subject=SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math]))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## removeStudentFromClassroom

- **assertEquals**

  Expected: `200`

  Actual: `200`

### Success

- **assertEquals**

  Expected: `200`

  Actual: `200`

### Same class

- **assertEquals**

  Expected: `400`

  Actual: `400`

- **assertNotNull**

  Expected: `not null`

  Actual: `[me.hsgamer.edublock.rs.test.model.output.AccountErrorListResponse$ErrorData@4b741d6d]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertEquals**

  Expected: `4`

  Actual: `4`

- **assertEquals**

  Expected: `2`

  Actual: `2`

### Same year

- **assertEquals**

  Expected: `400`

  Actual: `400`

- **assertNotNull**

  Expected: `not null`

  Actual: `[me.hsgamer.edublock.rs.test.model.output.AccountErrorListResponse$ErrorData@2eae8e6e]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertEquals**

  Expected: `4`

  Actual: `4`

- **assertEquals**

  Expected: `3`

  Actual: `3`

## removeTeacherFromClassroom

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertEquals**

  Expected: `200`

  Actual: `200`

## getClassroomList

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `[ClassroomOutput(id=1, name=10A2, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))), ClassroomOutput(id=2, name=10A3, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `2`

  Actual: `2`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## getClassroomListAsTeacher

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `[ClassroomOutput(id=1, name=10A2, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## getClassroomListAsStudent

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `[ClassroomOutput(id=1, name=10A2, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## getClassroomListAsHomeroom

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `[ClassroomOutput(id=1, name=10A2, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))), ClassroomOutput(id=2, name=10A3, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `2`

  Actual: `2`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## getClassroomById

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `ClassroomOutput(id=1, name=10A2, grade=10, year=2020, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

## updateClassroom

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertEquals**

  Expected: `10A1`

  Actual: `10A1`

- **assertEquals**

  Expected: `10`

  Actual: `10`

- **assertEquals**

  Expected: `2021`

  Actual: `2021`

- **assertEquals**

  Expected: `3`

  Actual: `3`

# RecordScenario

## requestChange

### Request 1

- **assertEquals**

  Expected: `200`

  Actual: `200`

### Request 2

- **assertEquals**

  Expected: `200`

  Actual: `200`

## bulkRequest

### Valid Request

- **assertEquals**

  Expected: `200`

  Actual: `200`

### Invalid Request

- **assertEquals**

  Expected: `400`

  Actual: `400`

## getPendingRecordEntries

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `[PendingRecordEntryOutput(id=1, subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math]), firstHalfScore=5.0, secondHalfScore=5.0, finalScore=5.0, requestDate=Fri Dec 02 11:59:20 ICT 2022, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))), PendingRecordEntryOutput(id=2, subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math]), firstHalfScore=10.0, secondHalfScore=10.0, finalScore=10.0, requestDate=Fri Dec 02 11:59:20 ICT 2022, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))), PendingRecordEntryOutput(id=3, subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math]), firstHalfScore=1.0, secondHalfScore=2.0, finalScore=3.0, requestDate=Fri Dec 02 11:59:20 ICT 2022, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))), PendingRecordEntryOutput(id=4, subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math]), firstHalfScore=5.0, secondHalfScore=6.0, finalScore=7.0, requestDate=Fri Dec 02 11:59:20 ICT 2022, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `4`

  Actual: `4`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## getPendingRecordEntriesByStudentId

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `[PendingRecordEntryOutput(id=1, subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math]), firstHalfScore=5.0, secondHalfScore=5.0, finalScore=5.0, requestDate=Fri Dec 02 11:59:20 ICT 2022, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))), PendingRecordEntryOutput(id=2, subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math]), firstHalfScore=10.0, secondHalfScore=10.0, finalScore=10.0, requestDate=Fri Dec 02 11:59:20 ICT 2022, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))), PendingRecordEntryOutput(id=3, subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math]), firstHalfScore=1.0, secondHalfScore=2.0, finalScore=3.0, requestDate=Fri Dec 02 11:59:20 ICT 2022, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))), PendingRecordEntryOutput(id=4, subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math]), firstHalfScore=5.0, secondHalfScore=6.0, finalScore=7.0, requestDate=Fri Dec 02 11:59:20 ICT 2022, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `4`

  Actual: `4`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## verifyRequest

### Deny request

- **assertEquals**

  Expected: `200`

  Actual: `200`

### Accept request

- **assertEquals**

  Expected: `200`

  Actual: `200`

## getRecordListByClassroomId

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `[RecordWithStudentOutput(classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))), entries=[RecordEntryOutput(subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math]), firstHalfScore=10.0, secondHalfScore=10.0, finalScore=10.0, requestDate=Fri Dec 02 11:59:20 ICT 2022, approvalDate=Fri Dec 02 11:59:20 ICT 2022, updateComplete=false, fromFabric=false, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), approver=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))], classification=ClassificationReportOutput(firstHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), secondHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), finalClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## getOwnRecordEntries

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `RecordOutput(classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))), entries=[RecordEntryOutput(subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math]), firstHalfScore=10.0, secondHalfScore=10.0, finalScore=10.0, requestDate=Fri Dec 02 11:59:20 ICT 2022, approvalDate=Fri Dec 02 11:59:20 ICT 2022, updateComplete=false, fromFabric=false, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), approver=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))], classification=ClassificationReportOutput(firstHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), secondHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), finalClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647)))`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## getRecordById

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `RecordOutput(classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))), entries=[RecordEntryOutput(subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math]), firstHalfScore=10.0, secondHalfScore=10.0, finalScore=10.0, requestDate=Fri Dec 02 11:59:20 ICT 2022, approvalDate=Fri Dec 02 11:59:20 ICT 2022, updateComplete=false, fromFabric=false, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), approver=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))], classification=ClassificationReportOutput(firstHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), secondHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), finalClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647)))`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

## getRecordListByGradeAndYear

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `[RecordWithStudentOutput(classroom=ClassroomOutput(id=1, name=10A1, grade=10, year=2021, homeroomTeacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com))), entries=[RecordEntryOutput(subjectId=1, subject=SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math]), firstHalfScore=10.0, secondHalfScore=10.0, finalScore=10.0, requestDate=Fri Dec 02 11:59:20 ICT 2022, approvalDate=Fri Dec 02 11:59:20 ICT 2022, updateComplete=false, fromFabric=false, teacher=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)), requester=AccountWithProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)), approver=AccountWithProfileOutput(account=AccountOutput(id=3, username=DaQ, role=TEACHER, createdAt=Fri Dec 02 11:59:19 ICT 2022), profile=ProfileOutput(id=3, firstName=Da, lastName=Quach, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=Ha Noi, phone=0123456789, email=daql@test.com)))], classification=ClassificationReportOutput(firstHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), secondHalfClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647), finalClassify=ClassificationOutput(identifier=, name=, otherNames=[], level=2147483647)), student=AccountWithStudentProfileOutput(account=AccountOutput(id=4, username=UyCHA, role=STUDENT, createdAt=Fri Dec 02 11:59:19 ICT 2022), student=StudentOutput(id=4, ethnic=Kinh, fatherName=Nguyen Van A, fatherJob=Giang vien, motherName=Tran Thi B, motherJob=Mua ban, guardianName=Trang Thi C, guardianJob=Ki su, homeTown=Can Tho), profile=ProfileOutput(id=4, firstName=Uy, lastName=Cao Hoang Anh, male=true, avatar=, birthDate=Thu Jan 01 08:00:00 ICT 1970, address=, phone=, email=)))]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

- **assertAnyMatch**

  Expected: `true`

  Actual: `true`

# SubjectScenario

## getSubjectList

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `[SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math]), SubjectOutput(id=2, identifier=PHYSICS, name=V???t l??, otherNames=[Physics, Phys]), SubjectOutput(id=3, identifier=CHEMISTRY, name=H??a h???c, otherNames=[Chemistry, Chem]), SubjectOutput(id=4, identifier=BIOLOGY, name=Sinh h???c, otherNames=[Biology, Bio]), SubjectOutput(id=5, identifier=INFORMATICS, name=Tin h???c, otherNames=[Informatics, Info]), SubjectOutput(id=6, identifier=LITERATURE, name=V??n h???c, otherNames=[Literature, Lit, V??n, Ng??? v??n]), SubjectOutput(id=7, identifier=HISTORY, name=L???ch s???, otherNames=[History, Hist]), SubjectOutput(id=8, identifier=GEOGRAPHY, name=?????a l??, otherNames=[Geography, Geo]), SubjectOutput(id=9, identifier=FOREIGN_LANGUAGE, name=Ngo???i ng???, otherNames=[Foreign Language, FL]), SubjectOutput(id=10, identifier=CITIZENSHIP, name=Gi??o d???c c??ng d??n, otherNames=[Citizenship, Cit, ?????o ?????c]), SubjectOutput(id=11, identifier=TECHNOLOGY, name=C??ng ngh???, otherNames=[Technology, Tech]), SubjectOutput(id=12, identifier=PHYSICAL, name=Th??? d???c, otherNames=[Physical Education, Phys Ed]), SubjectOutput(id=13, identifier=ART, name=M??? thu???t, otherNames=[Art]), SubjectOutput(id=14, identifier=MUSIC, name=??m nh???c, otherNames=[Music]), SubjectOutput(id=15, identifier=NATIONAL_EDUCATION, name=Gi??o d???c qu???c ph??ng, otherNames=[National Education, NE, Gi??o d???c QP-AN, QP-AN, Qu???c ph??ng])]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertFalse**

  Expected: `false`

  Actual: `false`

## getSubjectById

### Found

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `SubjectOutput(id=1, identifier=MATH, name=To??n, otherNames=[Mathematics, Math])`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `1`

  Actual: `1`

### Not Found

- **assertEquals**

  Expected: `404`

  Actual: `404`

# ClassificationScenario

## getClassificationList

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `[ClassificationOutput(identifier=GREAT, name=Gi???i, otherNames=[Great], level=1), ClassificationOutput(identifier=GOOD, name=Kh??, otherNames=[Good], level=2), ClassificationOutput(identifier=FAIR, name=Trung b??nh, otherNames=[], level=3), ClassificationOutput(identifier=BAD, name=Y???u, otherNames=[Bad], level=4), ClassificationOutput(identifier=FAIL, name=K??m, otherNames=[Fail], level=5)]`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertFalse**

  Expected: `false`

  Actual: `false`

## getClassificationById

### Found

- **assertEquals**

  Expected: `200`

  Actual: `200`

- **assertNotNull**

  Expected: `not null`

  Actual: `ClassificationOutput(identifier=GOOD, name=Kh??, otherNames=[Good], level=2)`

- **assertFalse**

  Expected: `false`

  Actual: `false`

- **assertEquals**

  Expected: `GOOD`

  Actual: `GOOD`

### Not Found

- **assertEquals**

  Expected: `404`

  Actual: `404`

# Final Report

- Scenario: 5

- Test: 42

- Assert: 235


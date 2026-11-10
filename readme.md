# Программ хангамжийн чанарын баталгаа ба туршилт - Лаб 9
B232270105 - Б.Хан-Эрдэнэ
<hr>

java -version:

```
java version "23.0.2" 2025-01-21
Java(TM) SE Runtime Environment (build 23.0.2+7-58)
Java HotSpot(TM) 64-Bit Server VM (build 23.0.2+7-58, mixed mode, sharing)
```
mvn -version:

```
Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: C:\Program Files\apache-maven-3.9.9
Java version: 23.0.2, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-23
Default locale: en_US, platform encoding: UTF-8
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
```
<hr>

### Хэсэг A

BRANCH_MISSED: 19 <br>
BRANCH_COVERED: 22 <br>
Хувь: 53.66%<br>

LINE_MISSED: 7 <br>
LINE_COVERED: 18 <br>
Хувь: 72%<br>

Шар ромботой мөрүүд нь бүх салбруудыг ажилуулаагүйг илтгэж байна. Үүнд жишээлвэл буруу оролт шалгах бүх if бичиглэлүүд багтаж байна. Үүний шалтгаанаар алдааг шидсэн мөрүүд улаан харагдаж, хэзээ ч ажиллаагүйг илтгэж байна.

<hr>

### Хэсэг B

Бүх кодыг ажиллуулахад шаардсан тестүүд: 14 <br>

BRANCH_MISSED: 0 <br>
BRANCH_COVERED: 41 <br>

LINE_MISSED: 0 <br>
LINE_COVERED: 25 <br>

[CFG зураг](cfg.png)    

### Хэсэг C

Давталтын заагын тестүүд:
```java
// null
@Test
void gpaThrowsForNullArray() {
    assertThrows(IllegalArgumentException.class, () -> calc.gpa(null));
}

// 0
@Test 
void gpaThrowsForEmptyArray() {
    assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[0]));
}

// 1
@Test
void gpaReturnsCorrectlyForOneValue() {
    double[] scores = {95};
    assertEquals(4.0, calc.gpa(scores), 0.0001);
}

 // 2+
@Test
void gpaReturnsAverageOfLetterGradePoints() {
    double[] scores = {95, 85, 75, 65, 50};
    assertEquals(2.0, calc.gpa(scores), 0.0001);
}
```

gpa() методод давталт байгаа учир 0, 1, 2+ удаа давтуулах тест үүсгэх хэрэгтэй байсан. 0 удаа давтах тест нь давталтыг бүрэн аласгахад ямар хариу өгөх, 1 удаа давтах тест нь давталтад орох ба гарах нь зөв явагдах, 2 эсвэл илүү давтах тест нь давталт хоорондын ажиллагаа хэвийн байлгахыг хангана.

### Хэсэг D (гол дүгнэлт)

Унасан тест: `letterGradeParametrizedTest(String, double)`, мөр 34 <br>
(параметрийн тестийн 8-р өгөгдөлд унасан)

Энэ лабораторийн хичээлээр JaCoCo багажыг ашиглан тест бичэхэд тестлэгдэж байгаа кодын хэр ихийг ажиллуулж, идэвхитэй тест бичиж байна уу гэдгийг мэдэж болох юм. JaCoCo нь код хаана, ямар нөхцлөөр салбарлаж, нийт хэдэн салбар байгааг харуулж, тест нь кодын хэдэн хувийг ажиллуулсан баттай тоо, мэдээллийг харуулдаг. 

Гэвч coverage-г 100% болтол нь тест бичих нь программын бүх гарах алдааг мэднэ гэсэн үг огт биш. Лабийн ажилд ашиглагсан letterGrade метод 60 оноо авсан бол D дүн буцаана хэмээн спецификацид бичсэн бол жинхэнээсээ 60 оноонд F дүн буцааж байв. Энд > ба >= харьцуулалтууд ижил салбарууд гаргадаг ба зөвхөн заагийн утгыг шалгасан тест энэ согогыг олох байлаа. Code coverage нь тест бичих боломжтой хамралт байхгүй хэсгүүд рүү зааж, харин хамралттай хэсэг "дахин үзэх хэрэггүй" хэмээх утгатай биш.

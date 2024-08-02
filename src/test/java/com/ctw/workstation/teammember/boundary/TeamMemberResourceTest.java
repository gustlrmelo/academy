//package com.ctw.workstation.teammember.boundary;
//
//import com.ctw.workstation.config.DatabaseTestResource;
//import com.ctw.workstation.team.entity.Team;
//import com.ctw.workstation.teammember.entity.TeamMember;
//import io.quarkus.test.common.QuarkusTestResource;
//import io.quarkus.test.junit.QuarkusTest;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.equalTo;
//
//import java.util.UUID;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.hasSize;
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//@QuarkusTest
//@QuarkusTestResource(DatabaseTestResource.class)
//class TeamMemberResourceTest {
//
//    private Team team;
//    private TeamMember teamMember;
//    private UUID teamMemberId;
//    private UUID teamId;
//
//    @BeforeEach
//    void setup(){
//        team = new Team("null", "productTest", LocalDateTime.now(),  LocalDateTime.now(), "Lisbon");
//        Response response = given()
//                .contentType("application/json")
//                .body(team)
//                .when().post("/teams")
//                .then()
//                .statusCode(201)
//                .extract().response();
//        teamId = UUID.fromString(response.jsonPath().getString("id"));
//        teamMember = new TeamMember( teamId, "MemberTest","CTW-03451", LocalDateTime.now(), LocalDateTime.now() );
//
//        Response response2 = given()
//                .contentType("application/json")
//                .body(teamMember)
//                .when().post("/teammembers")
//                .then()
//                .statusCode(201)
//                .extract().response();
//        teamMemberId = UUID.fromString(response2.jsonPath().getString("id"));
//    }
//
//    @Test
//    public void testGetTeamMemberById404() {
//        UUID teamMemberId404 = UUID.randomUUID();
//        given()
//                .pathParam("id", teamMemberId404)
//                .when().get("/teammembers/{id}")
//                .then()
//                .statusCode(404);
//    }
//
//}
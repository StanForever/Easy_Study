package com.example.pranitraje.easy_study;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class UniversityPapers extends AppCompatActivity {
    Spinner semester_input,branch_input,subject_input,year_input;
    ArrayAdapter<String> adapter1,adapter2,adapter3,adapter4;
    String semester,branch,subject,year,url;
    Button view_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_papers);
        semester_input=(Spinner)findViewById(R.id.semester_input);
        branch_input=(Spinner)findViewById(R.id.branch_input);
        subject_input=(Spinner)findViewById(R.id.subject_input);
        year_input=(Spinner)findViewById(R.id.year_input);
        view_button=(Button)findViewById(R.id.view_button);
        List<String> semlist=new ArrayList<String>();
        semlist.add("I");
        semlist.add("II");
        semlist.add("III");
        semlist.add("IV");
        semlist.add("V");
        semlist.add("VI");
        semlist.add("VII");
        semlist.add("VIII");
        adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,semlist);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semester="";branch="";subject="";year="";url="";
        semester_input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                semester=String.valueOf(semester_input.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                semester="I";
            }
        });
        semester_input.setAdapter(adapter1);
        List<String> branchlist=new ArrayList<String>();
        branchlist.add("Computers");
        branchlist.add("IT");
        branchlist.add("Electronics");
        branchlist.add("Production");
        adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,branchlist);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branch_input.setAdapter(adapter2);
        branch_input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                branch=String.valueOf(branch_input.getSelectedItem());
                switch(semester){
                    case "I" :
                        List<String> list1=new ArrayList<String>();
                        list1.add("EM");
                        list1.add("BEEE");
                        list1.add("AM1");
                        list1.add("AC1");
                        list1.add("AP1");
                        list1.add("EVS");
                        adapter3=new ArrayAdapter<String>(UniversityPapers.this,android.R.layout.simple_spinner_item,list1);
                        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        subject_input.setAdapter(adapter3);
                    break;
                    case "II" :
                        List<String> list2=new ArrayList<String>();
                        list2.add("ED");
                        list2.add("CS");
                        list2.add("AM2");
                        list2.add("AC2");
                        list2.add("AP2");
                        list2.add("SPA");
                        adapter3=new ArrayAdapter<String>(UniversityPapers.this,android.R.layout.simple_spinner_item,list2);
                        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        subject_input.setAdapter(adapter3);
                    break;
                    case "III" :
                        switch (branch) {
                            case "Computers" :
                                List<String> list3=new ArrayList<String>();
                                list3.add("AM3");
                                list3.add("OOPM");
                                list3.add("DS");
                                list3.add("ECCF");
                                list3.add("DLDA");
                                list3.add("DIS");
                                adapter3=new ArrayAdapter<String>(UniversityPapers.this,android.R.layout.simple_spinner_item,list3);
                                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                subject_input.setAdapter(adapter3);
                            case "IT" :
                            case "Electronics" :
                            case "Production" :
                        }break;
                    case "IV" :
                        switch (branch) {
                            case "Computers" :
                                List<String> list4=new ArrayList<String>();
                                list4.add("AM4");
                                list4.add("DBMS");
                                list4.add("CG");
                                list4.add("AOA");
                                list4.add("COA");
                                list4.add("TCS");
                                adapter3=new ArrayAdapter<String>(UniversityPapers.this,android.R.layout.simple_spinner_item,list4);
                                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                subject_input.setAdapter(adapter3);
                            case "IT" :
                            case "Electronics" :
                            case "Production" :
                        }break;
                    case "V" :
                        switch (branch) {
                            case "Computers" :
                                List<String> list=new ArrayList<String>();
                                list.add("CN");
                                list.add("MP");
                                list.add("OS");
                                list.add("SOOAD");
                                adapter3=new ArrayAdapter<String>(UniversityPapers.this,android.R.layout.simple_spinner_item,list);
                                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                subject_input.setAdapter(adapter3);break;
                            case "IT" :
                            case "Electronics" :
                            case "Production" :
                        }break;
                    case "VI" :
                        switch (branch) {
                            case "Computers" :
                                List<String> list=new ArrayList<String>();
                                list.add("SPCC");
                                list.add("MCC");
                                list.add("DD");
                                list.add("SE");
                                adapter3=new ArrayAdapter<String>(UniversityPapers.this,android.R.layout.simple_spinner_item,list);
                                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                subject_input.setAdapter(adapter3);break;
                            case "IT" :
                            case "Electronics" :
                            case "Production" :
                        }break;
                    case "VII" :
                        switch (branch) {
                            case "Computers" :
                            case "IT" :
                            case "Electronics" :
                            case "Production" :
                        }break;
                    case "VIII" :
                        switch (branch) {
                            case "Computers" :
                            case "IT" :
                            case "Electronics" :
                            case "Production" :
                        }break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                branch="Computers";
                switch (semester) {
                    case "I": break;
                    case "II": break;
                    case "III": break;
                    case "IV": break;
                    case "V": List<String> list5=new ArrayList<String>();
                        list5.add("CN");
                        list5.add("MP");
                        list5.add("OS");
                        list5.add("SOOAD");
                        adapter3=new ArrayAdapter<String>(UniversityPapers.this,android.R.layout.simple_spinner_item,list5);
                        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        subject_input.setAdapter(adapter3);break;
                    case "VI": List<String> list6=new ArrayList<String>();
                        list6.add("SPCC");
                        list6.add("MCC");
                        list6.add("DD");
                        list6.add("SE");
                        adapter3=new ArrayAdapter<String>(UniversityPapers.this,android.R.layout.simple_spinner_item,list6);
                        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        subject_input.setAdapter(adapter3);break;
                    case "VII": break;
                    case "VIII": break;
                }
            }
        });
        subject_input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subject=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //adapter3=ArrayAdapter.createFromResource(this,R.array.semester_no,android.R.layout.simple_spinner_item);
        List<String> yearlist = new ArrayList<String>();
        yearlist.add("DEC 16");
        yearlist.add("MAY 16");
        yearlist.add("DEC 15");
        yearlist.add("MAY 15");
        yearlist.add("DEC 14");
        yearlist.add("MAY 14");
        adapter4=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,yearlist);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        year_input.setAdapter(adapter4);
        year_input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                year=parent.getItemAtPosition(position).toString();
                switch(subject){
                    case "EM":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-3/AM3.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem3/AM3.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM3.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%203/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M3.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE3-comp/applied%20maths-3.pdf";break;
                        }break;
                    case "BEE":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-3/AM3.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem3/AM3.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM3.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%203/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M3.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE3-comp/applied%20maths-3.pdf";break;
                        }break;
                    case "AM1":
                        switch(year){
                            case "DEC 16":url="https://firebasestorage.googleapis.com/v0/b/easystudy-e2cd4.appspot.com/o/I%2FAM1%2FAM1-D14.pdf?alt=media&token=fe75a12d-0b2c-4e0d-980b-b5d171360afa";break;
                            case "MAY 16":url="https://firebasestorage.googleapis.com/v0/b/easystudy-e2cd4.appspot.com/o/I%2FAM1%2FAM1-M16.pdf?alt=media&token=00d3acef-4f9f-40b0-9eed-f37446980adf";break;
                            case "DEC 15":url="https://firebasestorage.googleapis.com/v0/b/easystudy-e2cd4.appspot.com/o/I%2FAM1%2FAM1-D15.pdf?alt=media&token=ed7797b1-188c-4b7c-a7b8-16096d9a027b";break;
                            case "MAY 15":url="https://firebasestorage.googleapis.com/v0/b/easystudy-e2cd4.appspot.com/o/I%2FAM1%2FAM1-M15.pdf?alt=media&token=44cdb0e8-6557-4032-ae7c-8322a83b37b3";break;
                            case "DEC 14":url="https://firebasestorage.googleapis.com/v0/b/easystudy-e2cd4.appspot.com/o/I%2FAM1%2FAM1-D14.pdf?alt=media&token=fe75a12d-0b2c-4e0d-980b-b5d171360afa";break;
                            case "MAY 14":url="https://firebasestorage.googleapis.com/v0/b/easystudy-e2cd4.appspot.com/o/I%2FAM1%2FAM1-M14.pdf?alt=media&token=2df28468-4827-4e08-a074-ad293166b6ef";break;
                        }break;
                    case "AC1":
                        switch(year){
                            case "DEC 16":url="https://firebasestorage.googleapis.com/v0/b/easystudy-e2cd4.appspot.com/o/I%2FAC1%2FAC1-D16.pdf?alt=media&token=029dc23f-f8b8-44a3-acea-c8ce20455dbe";break;
                            case "MAY 16":url="https://firebasestorage.googleapis.com/v0/b/easystudy-e2cd4.appspot.com/o/I%2FAC1%2FAC1-M16.pdf?alt=media&token=4c260bef-4ddf-4698-8bfa-e76abce143ec";break;
                            case "DEC 15":url="https://firebasestorage.googleapis.com/v0/b/easystudy-e2cd4.appspot.com/o/I%2FAC1%2FAC1-D15.pdf?alt=media&token=365b52b4-dc88-45d8-8329-6a5abf5f848c";break;
                            case "MAY 15":url="https://firebasestorage.googleapis.com/v0/b/easystudy-e2cd4.appspot.com/o/I%2FAC1%2FAC1-M15.pdf?alt=media&token=272563ea-b2f2-48ff-b33e-f76209554e12";break;
                            case "DEC 14":url="https://firebasestorage.googleapis.com/v0/b/easystudy-e2cd4.appspot.com/o/I%2FAC1%2FAC1-D14.pdf?alt=media&token=18a3e72f-b4c1-4aeb-8a1e-d4ef291c6ded";break;
                            case "MAY 14":url="https://firebasestorage.googleapis.com/v0/b/easystudy-e2cd4.appspot.com/o/I%2FAC1%2FAC1-M14.pdf?alt=media&token=77db0eb2-01ae-4da3-b579-989472438d7e";break;
                        }break;
                    case "AP1":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-3/AM3.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem3/AM3.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM3.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%203/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M3.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE3-comp/applied%20maths-3.pdf";break;
                        }break;
                    case "EVS":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-3/AM3.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem3/AM3.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM3.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%203/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M3.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE3-comp/applied%20maths-3.pdf";break;
                        }break;
                    case "ED":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-3/AM3.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem3/AM3.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM3.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%203/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M3.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE3-comp/applied%20maths-3.pdf";break;
                        }break;
                    case "CS":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-3/AM3.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem3/AM3.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM3.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%203/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M3.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE3-comp/applied%20maths-3.pdf";break;
                        }break;
                    case "AM2":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-3/AM3.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem3/AM3.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM3.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%203/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M3.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE3-comp/applied%20maths-3.pdf";break;
                        }break;
                    case "AC2":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-3/AM3.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem3/AM3.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM3.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%203/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M3.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE3-comp/applied%20maths-3.pdf";break;
                        }break;
                    case "AP2":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-3/AM3.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem3/AM3.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM3.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%203/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M3.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE3-comp/applied%20maths-3.pdf";break;
                        }break;
                    case "SPA":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-3/AM3.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem3/AM3.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM3.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%203/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M3.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE3-comp/applied%20maths-3.pdf";break;
                        }break;
                    case "AM3":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-3/AM3.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem3/AM3.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM3.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%203/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M3.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE3-comp/applied%20maths-3.pdf";break;
                        }break;
                    case "OOPM":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-3/OOPM.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem3/OOPM.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/OOPM.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%203/COMP/OOPM.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/OOPM.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE3-comp/oopm.pdf";break;
                        }break;
                    case "DS":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-3/DIS.pdf  ";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem-4/AM4.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM4.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%204/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M4.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE4-comp/am-4.pdf";break;
                        }break;
                    case "ECCF":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-4/AM4.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem-4/AM4.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM4.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%204/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M4.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE4-comp/am-4.pdf";break;
                        }break;
                    case "DLDA":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-4/AM4.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem-4/AM4.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM4.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%204/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M4.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE4-comp/am-4.pdf";break;
                        }break;
                    case "DIS":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-4/AM4.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem-4/AM4.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM4.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%204/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M4.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE4-comp/am-4.pdf";break;
                        }break;
                    case "AM4":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-4/AM4.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem-4/AM4.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AM4.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%204/COMP/MATHS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/M4.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE4-comp/am-4.pdf";break;
                        }break;
                    case "DBMS":
                        switch(year){
                            case "DEC 16":url="";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem-4/DBMS.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/DBMS.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%204/COMP/DBMS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/DBMS.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE4-comp/dbm.pdf";break;
                        }break;
                    case "CG":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-4/CG.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem-4/CG.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/CG.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%204/COMP/CG.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/CG.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE4-comp/cg.pdf";break;
                        }break;
                    case "COA":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-4/COA.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem-4/COA.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/COA.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%204/COMP/COA.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/COA.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE4-comp/coa.pdf";break;
                        }break;
                    case "AOA":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-4/AOA.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem-4/AOA.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/AOA.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%204/COMP/AOA.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/AOA.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE4-comp/analysis%20of%20alog..pdf";break;
                        }break;
                    case "TCS":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/SE/Comps/Sem-4/TCS.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/SE/Comps/Sem-4/TCS.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/SE/Comps/TCS.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/SE/SEM%204/COMP/TCS.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/TCS.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/s.e/J14SE4-comp/tcs.pdf";break;
                        }break;
                    case "OS":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/TE/IT/Sem-5/OS.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/TE/Comps/Sem-5/OS.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/TE/Comps/OS.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/missing/Operating System - M-15 - Comps.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/OS.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/t.e/J14TE5/OS-M14.pdf";break;
                        }break;
                    case "CN":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/TE/Comps/Sem-5/CN.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/TE/Comps/Sem-5/CN.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/TE/Comps/CN.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/TE/SEM 5/COMP/CN.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/CN.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/t.e/J14TE5/cn.pdf";break;
                        }break;
                    case "MP":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/TE/Comps/Sem-5/MP.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/TE/Comps/Sem-5/Microprocessor.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/TE/Comps/MP.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/TE/SEM 5/COMP/MICROPROCESSOR.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/MP.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/t.e/J14TE5/microprocessor.pdf";break;
                        }break;
                    case "SOOAD":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/TE/Comps/Sem-5/SOOAD.pdf";break;
                            case "MAY 16":url="";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/TE/Comps/SOOAD.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/TE/SEM 5/COMP/SAOOAD.pdf";break;
                            case "DEC 14":url="http://files.stupidsid.com/university_papers/engineering/D14/SOOAD.pdf";break;
                            case "MAY 14":url="http://files.stupidsid.com/university_papers/engineering/may2014/comp/t.e/J14TE5/web engg.pdf";break;
                        }break;
                    case "DD":
                        switch(year){
                            case "DEC 16":url="";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/TE/Comps/Sem-6/DD.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/TE/Comps/DD.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/TE/SEM%206/COMP/DD.pdf";break;
                            case "DEC 14":url="";break;
                            case "MAY 14":url="";break;
                        }break;
                    case "SPCC":
                        switch(year){
                            case "DEC 16":url="";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/TE/Comps/Sem-6/SPCC.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/TE/Comps/SPCC.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/TE/SEM%206/COMP/SPCC.pdf";break;
                            case "DEC 14":url="";break;
                            case "MAY 14":url="";break;
                        }break;
                    case "SE":
                        switch(year){
                            case "DEC 16":url="";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/TE/Comps/Sem-6/SE.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/TE/Comps/SE.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/TE/SEM%206/COMP/SOFTWARE%20ENGG.pdf";break;
                            case "DEC 14":url="";break;
                            case "MAY 14":url="";break;
                        }break;
                    case "MCC":
                        switch(year){
                            case "DEC 16":url="http://files.stupidsid.com/university_papers/engineering/D16/TE/Comps/Sem-6/MC&C.pdf";break;
                            case "MAY 16":url="http://files.stupidsid.com/university_papers/engineering/M16/TE/Comps/Sem-6/MCC.pdf";break;
                            case "DEC 15":url="http://files.stupidsid.com/university_papers/engineering/D15/TE/Comps/MCC.pdf";break;
                            case "MAY 15":url="http://files.stupidsid.com/university_papers/engineering/M15/TE/SEM%206/COMP/MCC.pdf";break;
                            case "DEC 14":url="";break;
                            case "MAY 14":url="";break;
                        }break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        view_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_paper);
                WebView paper=(WebView)findViewById(R.id.paper);
                paper.getSettings().setJavaScriptEnabled(true);
                paper.getSettings().setLoadWithOverviewMode(true);
                paper.getSettings().setUseWideViewPort(true);
                paper.setVerticalScrollBarEnabled(true);
                paper.setHorizontalScrollBarEnabled(true);
                try {
                    paper.loadUrl("http://docs.google.com/gview?embedded=true&url="+ URLEncoder.encode(url, "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                setContentView(paper);
            }
        });


    }
}

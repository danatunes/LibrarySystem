package com.company;

import com.company.TemplateDP.Faculty;
import com.company.TemplateDP.MemberRecord;
import com.company.TemplateDP.Student;

public class Main {
    public static void main(String[] args) throws Exception {

        MemberRecord memberRecord = new Student();
        memberRecord.payBookAmt();

        /*memberRecord = new Faculty();
        memberRecord.payBookAmt();
*/
    }
}

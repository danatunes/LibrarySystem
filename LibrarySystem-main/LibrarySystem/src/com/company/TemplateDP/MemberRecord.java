package com.company.TemplateDP;

import com.company.LibraryFacade;

public abstract class MemberRecord {

    private LibraryFacade libraryFacade = new LibraryFacade();

    public MemberRecord() {

    }

    public void requestBook() {
        libraryFacade.mainMenu();
    }


    abstract public void payBookAmt();

}

Thoughts on Development For Sakai's Syllabus
============================================

Links
-----

* Sakai's Getting Started: https://confluence.sakaiproject.org/display/BOOT/Sakai+development+getting+started
* Older Environment Setup: https://confluence.sakaiproject.org/display/BOOT/Development+Environment+Setup+Walkthrough
* More Relevant Environment Setup: https://confluence.sakaiproject.org/pages/viewpage.action?pageId=82249316
* Persistence Explainations (Syllabus uses Hibernate): https://confluence.sakaiproject.org/display/BOOT/Persistence
* Tomcat Local Server link (after Tomcat is run): http://localhost:8080/
* Locally hosted Sakai URL (after proper environment setup and Tomcat is run): http://localhost:8080/portal
* Java Server Faces Guide (I learned more from looking at Sakai's codebase): http://www.tutorialspoint.com/jsf/index.htm
* Sublime Text: http://www.sublimetext.com/
* Google (For everything else!): http://google.com

Thoughts on this Guide
----------------------

This is not a guide on how to program, but a guide on how to develop a mindset of understanding around the Syllabus feature within Sakai. Use the linked guides, google, and your programming intuition to grasp at any of the new concepts. If you know Java, and are aware of MVC style designs even a tiny bit, learning Sakai will come naturally in time. If your not confident in Java, there's still a chance that Sakai might still be right for you, but beware. Furthermore, take what I write with a grain of salt. At the moment, I'm still just a student, as you are right now. I'm not a dedicated Sakai developer, but someone who wanted to do some Open Source work within a projects course. Also, the majority of the Sakai code, including the syllabus section, was done by other people before me. The work I did on the syllabus was more so a patch to refresh the project with a few added features, so be aware that you will be working with code that's been passed around throughout the open source community, and consider it accordingly (for better and for worst). 

Thoughts on Setting Up your Development Environment
---------------------------------------------------

TAKE IT SLOW. Read the linked guides very carefully, and take each step as slow as possible. Both setup walkthroughs are messy and tremendously cluttered with steps; and yes, you'll run into many issues along the way. You'll get there, but it will take quite a long while. Personally, I spent a week trying to get my setup working -- just stick with it and be aware of what errors are saying, and how it relates to what each step is addressing. I would also suggest making your development area as seperate to your normal computer's setup as possible. This means that even though you might already have a version of Tomcat or Maven installed, definately use a new unique installation completely dedicated to this project environment. The only thing I used that existed before my time with Sakai was my Java installation, as I developed on OSX 10.8 and Java wasn't causing any installation issues, so I left it. 

Finally, the guides suggest you use Eclipse to develop your code. As a sane post-2010 developer, I would suggest instead to use something like Sublime Text 2 (or the most revelant version at the time of reading), and your machine's unique terminal application. It is just so much more usable, the features that Sublime Text provides are irreplacable (project-wide keyword search, amazing plugins, beautiful and usable interface, etc.), and Eclipse is just way to clunky, slow, and such a waste of screen real-estate. Furthermore, if you haven't yet started working with a unix-based terminal in your student career, you need to get on that right now, because its a skill that is required in any sort of software development career. Back in my first year of university I didn't know anything about dealing with UNIX and/or the terminal -- and in second year I didn't enjoy it when it was taught in 2211 (I think that was the course). But by third year, the power of effective terminal use is invaluable to speedy development, not to mention its necessity when dealing with git and (*shudder*) svn.

Thoughts on Sakai's Code and How the Pieces Works Together
----------------------------------------------------------

To begin, your going to find a project folder structure in the Sakai code base that follows the pattern: Root Sakai Folder (i.e. Sakai-src) -> Specific Section (i.e. sakai-syllabus), and then within the syllabus section, you will find 6 major folders that contain all the code that creates the syllabus feature on any Sakai system.  

These six folders are the following:

- components: There's not to much in this folder as it is generally there for the /src/webapp/WEB-INF/compontents.xml file, which has the purpose of mapping out the Beans and Resources used in the syllabus (i.e Hibernate persistance locations, the SyllabusManager file, SyllabusService, etc.)

- help: Generally speaking, you'll not really touch this folder ever. It contains the html pages for Sakai's help menu. 

- syllabus-api:  This is where all the java interface files are found for the major classes used in the Syllabus. Drill down into /src/java/org/../syllabus/ to find them all. I would say that the most used of these files during my development were the SyllabusManager (which at its essence is the overarching management portal for any sort of SyllabusItem and SyllabusData usages), as well as the obvious SyllabusItem and SyllabusData. Definitely study up on these critical pieces within the system, as they are the main actors within the whole syllabus, and will enlighten you on all the mechanics.                             

- syllabus-app:  This folder deals with the presentation layer of the product. If you drill down into /src/bundle/org/.../bundle/ you will find an assortment of language Messages files. These are the string contents used throughout the presentation (visual) layer of the application. You'll specifically be using the file Messages.properties for your work in the project. It's kind of baffling why JSF is design this way, but basically, in the JSF presentation files found in a later folder, if you want to have some text displayed visually to the user, you have to associate that text with a variable found within this Messages.properties file. It's weird, but just go with it. Next, if you drill down into /src/java/../jsf/syllabus/, you'll find the JSF structure files that are the customized-to-the-syllabus versions of JSF component structures and design (i.e. how the tables are structured to display syllabusData). Unless you are totally redesigning everything, you'll more then likely never need to open these files. Next, if you drill down into /src/java/../tool/syllabus/, you'll find three java files, the first two being usually ignored as they are for specific uses, yet a third, SyllabusTool.java, which I would say is one of the more important files in the whole system. SyllabusTool is what I would call the central hub of the system. When a presentation layer file's button is clicked, a SyllabusTool method is usually called which, for example, could then interact with the SyllabusManager to proceed with some requested Syllabus-related action, and then based on the result, this example SyllabusTool method would return a keyword that goes back to tell the presentation layer what to do next (i.e. load a new page, return an error page, etc). Continuing on, drilling down into /src/webapp/syllabus/ finds all the .jsp files, which are comparable to .html files in web development terms. These files are the page structures for each presentation level user interface, where buttons, tables, titles, and all the visual cues are designated. Finally, the last notable file in this folder is found in /src/webapp/WEB-INF/, and is called faces-config.xml. This important file is the translation xml data center that translates the returned keyword from a SyllabusTool method and gives the associated .jsp to open, called navigational rules & cases. Each navigational rule has a from-view-id, which is the origin .jsp, and list that provides the translations for the potential outcome .jsp addresses (from that origin .jsp). 

- syllabus-hbm: This folder, specifically in /src/java/../syllabus holds the Hibernate hbm.xml files for each object type that is stored in a persistance form, and in turn each of these object's implementation files. For more details on Hibernate (Sakai's main persistance) take a look at the link above, but to be honest, there is a severe lack of context and documentation on Hibernate in relation to Sakai, so I steered clear where possible. Hopefully you can find out more if needed. The implementation files are good resources to understanding the system, so take a look at them to build awareness on the relationship between SyllabusItem and SyllabusData. Be aware, during my time developing for the Syllabus, I was not able to successfully add an additional object type to the persistance system. If the need for a new persistable object is a part of your project goal, I hope you have better luck then me, as even after updating the components.xml, adding a new java object interface, a new implementation, and a new .hbm.xml for the implementation -- the database would not react to the new addition (add a new table) and the error report back was not providing enough context to move forward (nor was I able to change a current object's persistent table column elements).  

- syllabus-impl: This is a simple folder, as when you drill down into /src/java/.../syllabus, you'll find the remaining system implementation files -- and most importantly the SyllabusManagerImpl.java. The manager, as described earlier, is the control center for any sort of SyllabusItem and SyllabusData interactions between the SyllabusTool and the database. This file will most certainly be one of the few files that remains open during the whole development process alongside SyllabusTool.



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

This is not a guide on how to program, merely a guide on how to develop a mindset of understanding around the Syllabus feature within Sakai. Use the linked guides, google, and your programming intuition to grasp at any of the new concepts. If you know Java, and are aware of MVC style designs even a tiny bit, learning Sakai will come naturally in time. If your not confident in Java, there's still a chance that Sakai might still be right for you, but beware. Furthermore, take what I write with a grain of salt. At the moment, I'm still merely a student, just like you are right now. I'm not a dedicated Sakai developer, merely someone who wanted to do some Open Source work within a projects course. Also, the majority of the Sakai code, including the syllabus section, was done by other people before me. The work I did on the syllabus was more so a patch to refresh the project with a few added features, so be aware that you will be working with code that's been passed around throughout the open source community, and consider it accordingly (for better and for worst). 

Thoughts on Setting Up your Development Environment
---------------------------------------------------

TAKE IT SLOW. Read the linked guides very carefully, and take each step as slow as possible. Both setup walkthroughs are messy and tremendously cluttered with steps; and yes, you'll run into many issues along the way. You'll get there, but it will take quite a long while. Personally, I spent a week trying to get my setup working -- just stick with it and be aware of what errors are saying, and how it relates to what each step is addressing. I would also suggest making your development area as seperate to your normal computers setup as possible. This means that even though you might already have a version of Tomcat or Maven installed, definately use a new unique instillation completely dedicated to this environment. The only thing I used that existed before my time with Sakai was my Java installation, as I developed on OSX 10.8 and Java wasn't causing any installation issues, so I left it. 

Finally, the guides suggest you use Eclipse to develop your code. As a sane post-2010 developer, I would suggest instead to use something like Sublime Text 2 (or the most revelant version at the time of reading), and your machine's unique terminal application. It is just so much more usable, the features that SubText has are irreplacable (codebase wide key search, good plugins, beautiful and usable interface, etc.), and Eclipse is just way to clunky, slow, and such a waste of screen real-estate. If you haven't started working with a unix-based terminal yet in your student career, you need to get on that right now, because its a skill that is required in any sort of software development career. Back in my first year of university I didn't know anything about dealing with unix and/or the terminal -- and in second year I didn't enjoy it when it was taught in 2211 (I think that was the course). But by third year, the power of effective terminal use is invaluable to speedy development, not to mention its necessity when dealing with git and (*shudder*) svn.

Thoughts on Sakai's Code and How the Pieces Works Together
----------------------------------------------------------

Thoughts on Persistance in Sakai's Syllabus
-------------------------------------------



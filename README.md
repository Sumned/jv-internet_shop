

<html>
   <head>
      <title>Назва</title>
   </head>
   <body>
        <div class="Box-body p-5">
                <article class="markdown-body entry-content container-lg" itemprop="text"><h1><a id="user-content-internet-shop" class="anchor" aria-hidden="true" href="#internet-shop"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Internet-shop</h1>
        <p>Welcome</p>
        <h1><a id="user-content-table-of-contents" class="anchor" aria-hidden="true" href="#table-of-contents"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Table of Contents</h1>
        <ul>
        <li><a href="#purpose">Project purpose</a></li>
        <li><a href="#structure">Project structure</a></li>
        <li><a href="#developer-start">For developer</a></li>
        <li><a href="#authors">Authors</a></li>
        </ul>
        <h1><a id="user-content-project-purpose" class="anchor" aria-hidden="true" href="#project-purpose"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a><a name="user-content-purpose"></a>Project purpose</h1>
        <p>This is a template for creating an e-store.</p>
        <hr>
        It has login and registration forms.
        <p>There are controllers for working with items, users, orders and buckets:</p>
        <hr>
        Inject - for injection mock data,
        <p>Registration - for registering new users,</p>
        <p>Login -  for user authentication and authorization,</p>
        <p>Users - for displaying a list of all app users. Available for users with an ADMIN role only,</p>
        <p>Items - for displaying  all items in stock,</p>
        <p>Bucket - for displaying  user’s bucket. Available for users with a USER role only,</p>
        <p>Orders - for displaying user’s order history. Available for users with a USER role only,</p>
        <p>Logout - for logging out.</p>
        <hr>
        <h1><a id="user-content-project-structure" class="anchor" aria-hidden="true" href="#project-structure"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a><a name="user-content-structure"></a>Project Structure</h1>
        <ul>
        <li>Java 11</li>
        <li>Maven 4.0.0</li>        
        <li>javax.servlet 3.1.0</li>
        <li>jstl 1.2</li>
        <li>log4j 1.2.17</li>
        <li>maven-checkstyle-plugin</li>
        </ul>
        <hr>
        <h1><a id="user-content-for-developer" class="anchor" aria-hidden="true" href="#for-developer"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a><a name="user-content-developer-start"></a>For developer</h1>
        <p>Open the project in your IDE.</p>
        <p>Add it as maven project.</p>
        <p>Configure Tomcat:</p>
        <ul>
        <li>add artifact;</li>
        <li>add sdk 11.0.3</li>
        </ul>
        <p>Add sdk 11.0.3 in project struсture.</p>
        <p>Create a schema "dbinternetshop" in any SQL database.</p>
        <p>Use file interntetshop.src.main.java.resources.init_db.sql to create all the tables required by this app.</p>
        <p>At interntetshop.src.main.java.Factory class use username and password for your DB to create a Connection.</p>
        <p>At interntetshop.src.main.java.resources.hibernate.cfg.xml configure Hibernate with correct username and password.</p>
        <p>Change a path in interntetshop.src.main.java.resources.log4j.properties. It has to reach your logFile.</p>
        <p>Run the project.</p>
        <p>By default there’s one user with a USER role (login = 1, password = 1) and one – with an ADMIN role (login = 2, password = 2).</p>
        <hr>
        <h1><a id="user-content-authors" class="anchor" aria-hidden="true" href="#authors"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a><a name="user-content-authors"></a>Authors</h1>
        <ul>
        <li><a href="https://github.com/Sumned">Sumned</a></li>
        </ul>
        </article>
      </div>
          

          
   </body>
</html>
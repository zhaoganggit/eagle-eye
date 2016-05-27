package org.zhaogang.eagleeye.controllers;

import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

/**
 * Created by Joy.wang on 16-5-27.
 */
public class Application extends Controller {

    public  F.Promise<Result> index() {
        String title = "eagle-eye monitor";
        String body = "welcome to here!";
        F.Promise promise = F.Promise.promise(new F.Function0<Result>() {
            public Result apply() throws Throwable {
                return Results.ok(views.html.app.index.render(title, body));
            }
        });
        return promise;
    }
}

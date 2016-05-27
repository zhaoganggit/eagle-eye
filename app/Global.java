
import org.springframework.context.ApplicationContext;
import play.Application;
import play.GlobalSettings;
import play.libs.F;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import scala.concurrent.Future;

public final class Global extends GlobalSettings {

    @Override
    public void onStart(Application application)
    {

    }

    @Override
    public F.Promise<Result> onHandlerNotFound(Http.RequestHeader var1) {
        F.Promise promise = F.Promise.promise(new F.Function0<Result>() {
            public Result apply() throws Throwable {
                return Results.redirect("/");
            }
        });
        return promise;
    }
}

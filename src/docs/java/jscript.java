import javax.script.*;

import org.openjdk.nashorn.api.scripting.NashornScriptEngineFactory;

import java.io.FileReader;
import net.canarymod.api.inventory.ItemType;

public class jscript
{
    public static void main(String[] args) throws Exception
    {
    	NashornScriptEngineFactory factory = new org.openjdk.nashorn.api.scripting.NashornScriptEngineFactory();
//        ScriptEngineManager factory = new ScriptEngineManager();
    	ScriptEngine engine = factory.getScriptEngine();
//        ScriptEngine engine = factory.getEngineByName("JavaScript");
        java.io.File file = new java.io.File(args[0]);
        engine.put("engine",engine);
        engine.put("args",args);
	try { 
	    engine.put("cmItemTypeClass",Class.forName("net.canarymod.api.inventroy.ItemType"));
	}catch(Exception e){
	}
        FileReader fr = new java.io.FileReader(file);
        engine.eval(fr);
        fr.close();
    }
}

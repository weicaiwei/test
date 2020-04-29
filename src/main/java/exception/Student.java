package exception;


/**
 *
 */
public class Student {

    /**
     *
     * @param someThing
     * @return
     * @throws CustomRuntimeException
     */
    public String ask_1(String someThing) throws CustomRuntimeException {
        if (someThing.equals("脏话")) {
            throw new CustomRuntimeException();
        }
        System.out.println("我能到这吗");
        return "完事了";
    }

    public String ask_2(String someThing) throws CustomException, Custom2Exception {
        if (someThing.equals("脏话")) {
            throw new CustomException();
        }
        if (someThing.equals("还在说脏话")) {
            throw new Custom2Exception();
        }
        System.out.println("我能到这吗");
        return "完事了";
    }

    public void ask_3(String someThing) throws OhterException {
        try {
            ask_2(someThing);
        } catch (CustomException e) {


            throw new OhterException("wocao");
        }

    }

}

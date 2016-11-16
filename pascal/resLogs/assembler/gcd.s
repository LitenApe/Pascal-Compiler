        .globl  main                    
main:
        call    prog$gcd_1              # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
func$gcd_2:
        enter   $32,$2                  # Start of gcd
                                        # Start if-statement
        movl    -8(%ebp),%edx           
        movl    12(%edx),%eax           #   n
        pushl   %eax                    #  in Expression
        movl    $0,%eax                 #   0
        popl    %ecx                    #  in Expression
        cmpl    %eax,%ecx               # in Expression
        movl    $0,%eax                 # idk
        sete    %al                     # Test =
        cmpl    $0,%eax                 # --- if statm
        je      .L0003                  # --- if statm1
        movl    -8(%ebp),%edx           
        movl    8(%edx),%eax            #   m
        movl    -8(%ebp),%edx           
        movl    %eax,-32(%edx)          # gcd :=
        jmp     .L0004                  # --- if statm2
.L0003:
        movl    -8(%ebp),%edx           
        movl    8(%edx),%eax            #   m
        pushl   %eax                    # idk in Term
        movl    -8(%ebp),%edx           
        movl    12(%edx),%eax           #   n
        movl    %eax,%ecx               
        popl    %eax                    
        cdq                             
        idivl   %ecx                    
        movl    %edx,%eax               #   mod
        pushl   %eax                    #  Funccall: Push param #2
        movl    -8(%ebp),%edx           
        movl    12(%edx),%eax           #   n
        pushl   %eax                    #  Funccall: Push param #1
        call    func$gcd_2              
        addl    $8,%esp                 #  Pop parameters
        movl    -8(%ebp),%edx           
        movl    %eax,-32(%edx)          # gcd :=
.L0004:
                                        # End if-statemen
        movl    -32(%ebp),%eax          # --- func decl
        leave                           # --- func decl
        ret                             # --- func decl
prog$gcd_1:
        enter   $36,$1                  # Start of gcd
        movl    $462,%eax               #   462
        pushl   %eax                    #  Funccall: Push param #2
        movl    $1071,%eax              #   1071
        pushl   %eax                    #  Funccall: Push param #1
        call    func$gcd_2              
        addl    $8,%esp                 #  Pop parameters
        movl    -4(%ebp),%edx           
        movl    %eax,-36(%edx)          # res :=
        movl    $71,%eax                #   'G'
        pushl   %eax                    # Push param #1
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $67,%eax                #   'C'
        pushl   %eax                    # Push param #2
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $68,%eax                #   'D'
        pushl   %eax                    # Push param #3
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $40,%eax                #   '('
        pushl   %eax                    # Push param #4
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $1071,%eax              #   1071
        pushl   %eax                    # Push param #5
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $44,%eax                #   ','
        pushl   %eax                    # Push param #6
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $462,%eax               #   462
        pushl   %eax                    # Push param #7
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $41,%eax                #   ')'
        pushl   %eax                    # Push param #8
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    # Push param #9
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    -4(%ebp),%edx           
        movl    -36(%edx),%eax          #   res
        pushl   %eax                    # Push param #10
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $10,%eax                #   10
        pushl   %eax                    # Push param #11
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of gcd
        ret                             

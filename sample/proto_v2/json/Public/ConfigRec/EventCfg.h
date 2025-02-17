/**
 * This file is generated by xresloader 2.12.1, please don't edit it.
 * You can find more information about this xresloader on https://xresloader.atframe.work/ .
 * If there is any problem, please find or report issues on https://github.com/xresloader/xresloader/issues .
 */
#pragma once
// Test event_cfg with oneof fields

#include "CoreMinimal.h"
#include "UObject/ConstructorHelpers.h"
#include "Engine/DataTable.h"
#include "ConfigRec/EventRewardItem.h"
#include "ConfigRec/EventRuleItem.h"
#include "EventCfg.generated.h"


USTRUCT(BlueprintType)
struct FEventCfg : public FTableRowBase
{
    GENERATED_USTRUCT_BODY()

    // Start of fields
    /** Field Type: STRING, Name: Name, Index: 0. This field is generated for UE Editor compatible. **/
    UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "XResConfig")
    FName Name;

    /** Field Type: INT, Name: Id, Index: 1. This field is generated for UE Editor compatible. **/
    UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "XResConfig")
    int32 Id;

    /** Field Type: INT, Name: Process, Index: 2. This field is generated for UE Editor compatible. **/
    UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "XResConfig")
    int32 Process;

    /** Field Type: oneof/union -> FString, Name: Reward, Index: 0. This field is generated for UE Editor compatible. **/
    UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "XResConfig")
    FString Reward;

    /** Field Type: oneof/union -> FString, Name: UnlockType, Index: 1. This field is generated for UE Editor compatible. **/
    UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "XResConfig")
    FString UnlockType;

    /** Field Type: MESSAGE, Name: Rule, Index: 6. This field is generated for UE Editor compatible. **/
    UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "XResConfig")
    FEventRuleItem Rule;

    /** Field Type: MESSAGE, Name: SpecifyField, Index: 7. This field is generated for UE Editor compatible. **/
    UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "XResConfig")
    FEventRuleItem SpecifyField;

    /** Field Type: MESSAGE, Name: Item, Index: 11. This field is generated for UE Editor compatible. **/
    UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "XResConfig")
    FEventRewardItem Item;

    /** Field Type: LONG, Name: UserExp, Index: 12. This field is generated for UE Editor compatible. **/
    UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "XResConfig")
    int64 UserExp;

    /** Field Type: STRING, Name: Note, Index: 13. This field is generated for UE Editor compatible. **/
    UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "XResConfig")
    FString Note;

    /** Field Type: INT, Name: EnumType, Index: 14. This field is generated for UE Editor compatible. **/
    UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "XResConfig")
    int32 EnumType;

    /** Field Type: INT, Name: UserLevel, Index: 51. This field is generated for UE Editor compatible. **/
    UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "XResConfig")
    int32 UserLevel;

    /** Field Type: MESSAGE, Name: TestArr, Index: 91. This field is generated for UE Editor compatible. **/
    UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "XResConfig")
    TArray< FEventRuleItem > TestArr;

    /** Field Type: MESSAGE, Name: TestEmptyArr, Index: 92. This field is generated for UE Editor compatible. **/
    UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "XResConfig")
    TArray< FEventRuleItem > TestEmptyArr;

};


UCLASS(Blueprintable, BlueprintType)
class UEventCfgHelper : public UObject
{
    GENERATED_BODY()

public:
    UEventCfgHelper();

    void OnReload();

    void SetLoader(TSharedPtr<ConstructorHelpers::FObjectFinder<UDataTable> > NewLoader);

    void InitializeDefaultLoader() const;

    void DisableDefaultLoader();

    static FName GetRowName(int32 Id, int32 Process);

    UFUNCTION(BlueprintCallable, Category = "XResConfig")
    FName GetDataRowName(int32 Id, int32 Process) const;

    UFUNCTION(BlueprintCallable, Category = "XResConfig")
    FName GetTableRowName(const FEventCfg& TableRow) const;

    UFUNCTION(BlueprintCallable, Category = "XResConfig")
    const FEventCfg& GetDataRowByName(const FName& Name, bool& IsValid) const;

    UFUNCTION(BlueprintCallable, Category = "XResConfig")
    const FEventCfg& GetDataRowByKey(int32 Id, int32 Process, bool& IsValid) const;

    bool ForeachRow(TFunctionRef<void (const FName& Key, const FEventCfg& Value)> Predicate) const;

    UFUNCTION(BlueprintCallable, Category = "XResConfig")
    UDataTable* GetRawDataTable(bool& IsValid) const;

    static void ClearRow(FEventCfg& TableRow);

    UFUNCTION(BlueprintCallable, Category = "XResConfig")
    void ClearDataRow(FEventCfg& TableRow) const;

private:
    TSharedPtr<ConstructorHelpers::FObjectFinder<UDataTable> > Loader;
    UDataTable* DataTable;
    bool EnableDefaultLoader;
    FEventCfg Empty;
};

